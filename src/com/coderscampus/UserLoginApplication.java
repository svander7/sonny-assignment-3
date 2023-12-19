package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {
	
	public static void main(String[] args) {

		String filePath = "data.txt";
		User[] users = CollectedData.DataFromFile(filePath);

		Scanner scanner = new Scanner(System.in);
		int maxAttempts = 5;
		int attempts = 0;

		while (attempts < maxAttempts) {
			System.out.println("Enter your email: ");
			String username = scanner.nextLine();
			System.out.println("Enter your Password: ");
			String password = scanner.nextLine();

			User userCheck = findUser(username, password, users);

			if (userCheck != null && userCheck.getPassword().equals(password)) {
				System.out.println("Welcome, " + userCheck.getName());
				break;
			} else {
				attempts++;
				if (attempts == maxAttempts) {
					System.out.println("Too many failed login attempts, you are now locked out!");
					scanner.close();
					break;
				} else {
					System.out.println("Invalid login, please try again.");
				}
			}
		}
	}

	public static User findUser(String username, String password, User[] users) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				return user;
			}
		}
		return null;
	}
}