package com.jspiders.car_dekho_jdbc.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	public static void addCar(int id, String name, String brand, String fuel, int price) throws IOException {
		try {

			connection = openConnection();
			query = "INSERT INTO car VALUES(?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setString(4, fuel);
			preparedStatement.setInt(5, price);
			preparedStatement.addBatch();
			preparedStatement.executeBatch();

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	public static void updateDetails(int id, int price) throws IOException {
		try {
			connection = openConnection();
			query = "UPDATE car set price = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " record(s) updated");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void searchCar(int id) throws ClassNotFoundException {
		try {
			connection = openConnection();
			query = "SELECT * FROM car WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			System.out.println("\nID\tName\tBrand\tFuel\tPrice\t");
			System.out.println("__________________________________________");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print(resultSet.getString(3) + "\t");
				System.out.print(resultSet.getString(4) + "\t");
				System.out.print(resultSet.getInt(5) + "\n\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void deleteCar(int id) throws IOException {
		try {
			connection = openConnection();
			query = "DELETE FROM car WHERE id=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			if (res > 0) {
				System.out.println("Selected car record has been deleted...\n\n");
			} else {
				System.out.println("Selected ID is not present...");
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void allCars() throws ClassNotFoundException {
		try {
			connection = openConnection();
			query = "SELECT * FROM car";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			System.out.println("\nID\t\tName\t\tBrand\t\tFuel\t\tPrice\t\t\n");
			System.out.println("_______________________________________________________________________");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1) + "\t|\t");
				System.out.print(resultSet.getString(2) + "\t|\t");
				System.out.print(resultSet.getString(3) + "\t|\t");
				System.out.print(resultSet.getString(4) + "\t|\t");
				System.out.print(resultSet.getInt(5) + "\n\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public static Connection openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3305/weja4", "root", "root");
	}

	public static void closeConnection() throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
}