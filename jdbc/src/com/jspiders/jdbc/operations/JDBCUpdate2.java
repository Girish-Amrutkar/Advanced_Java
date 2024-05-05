package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate2 {

	private static PreparedStatement preparedStatement;
	private static Connection connection;
	private static String query;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter user ID: ");
		int id = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Set the password for given user: ");
		String setPass = scanner.nextLine();
		scanner.close();
		
		try {
			openConnection();
			query = "UPDATE user SET password = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, setPass);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			System.out.println("Password updated for user");
			System.out.println(res);
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
