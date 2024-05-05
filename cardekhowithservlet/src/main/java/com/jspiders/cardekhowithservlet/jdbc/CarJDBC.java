package com.jspiders.cardekhowithservlet.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspiders.cardekhowithservlet.object.Car;
import com.mysql.cj.jdbc.Driver;

public class CarJDBC {

	private static Driver driver;
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	
	private static void openConnection() throws SQLException {
		driver = new com.mysql.jdbc.Driver();
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/weja4", "root", "root");
	}
	
	private static void closeConnection() throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null ) {
			connection.close();
		}
		DriverManager.deregisterDriver(driver);
	}
	
	public static int addCar(int id, String name, String brand, String fuel_type, double price) {
		int res = 0;
		try {
			openConnection();
			query = "INSERT INTO cars VALUES (?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, brand);
			preparedStatement.setString(4, fuel_type);
			preparedStatement.setDouble(5, price);
			res = preparedStatement.executeUpdate();
			System.out.println(res +" no. of row(s) affected.");
			
			
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;	
	}
	
	public static List<Car> searchAllCars() {
		List<Car> cars = new ArrayList<>();
		try {
			openConnection();
			query = "SELECT * FROM cars";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Car car = new Car();
				car.setId(resultSet.getInt(1));
				car.setName(resultSet.getString(2));
				car.setBrand(resultSet.getString(3));
				car.setFuel_type(resultSet.getString(4));
				car.setPrice(resultSet.getDouble(5));
				cars.add(car);
			}
			closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cars;
	}
	
	public static int deleteCar(int id) {
		int res = 0;
		try {
			openConnection();
			query = "DELETE FROM cars WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			res = preparedStatement.executeUpdate();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
		
	}

	public static int updateCar(int id, String name) {
		int res = 0;
		try {
			openConnection();
			query = "UPDATE cars SET NAME = ? WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			res = preparedStatement.executeUpdate();
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
//	public static void updateCar(int id) {
//		
//	}
	
}
