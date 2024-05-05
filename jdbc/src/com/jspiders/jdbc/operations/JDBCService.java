package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCService {

	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	private static ResultSet resultSet;
	
	public static void signUp(Scanner scanner) {
		System.out.println("Enter user id: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter user name: ");
		String user = scanner.nextLine();
		System.out.println("Enter user email: ");
		String email = scanner.nextLine();
		System.out.println("Enter user password: ");
		String password = scanner.nextLine();
		
		try {
			openConnection();
			query = "INSERT INTO user VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, user);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			int res = preparedStatement.executeUpdate();
			if (res == 1) {
				System.out.println("Signed Up...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void logIn(Scanner scanner) {
		scanner.nextLine();
		System.out.println("Enter your email: ");
		String email = scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.nextLine();
		
		try {
			openConnection();
			query = "SELECT * FROM user WHERE email = ? AND password = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println("Logged in...");
				System.out.println("Welcome to an Application...");
			}else {
				System.out.println("Invalid Credentials...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/weja4", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
