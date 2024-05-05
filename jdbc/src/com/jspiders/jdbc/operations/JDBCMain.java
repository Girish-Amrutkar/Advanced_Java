package com.jspiders.jdbc.operations;

import java.util.Scanner;

public class JDBCMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 to Sign Up\nEnter 2 to Log In\nEnter 2 to Exit.");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				JDBCService.signUp(scanner);
				break;
			case 2:
				JDBCService.logIn(scanner);
				break;
			case 3:
				flag = false;
				System.out.println("Thank You!!!");
			default:
				System.out.println("Invalid Selection...");
				break;
			}
		}
		scanner.close();
	}
}
