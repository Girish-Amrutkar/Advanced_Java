package com.jspiders.jdbc.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCall2 {

	private static CallableStatement callableStatement;
	private static Connection connection;
	private static ResultSet resultSet;
	private static String query;
	
	public static void main(String[] args) throws SQLException {
		try {
			openConnection();
			query = "call sort()";
			callableStatement = connection.prepareCall(query);
			callableStatement.execute();
			resultSet = callableStatement.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/weja4", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (callableStatement != null) {
			callableStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
