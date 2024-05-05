package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {

	public static void main(String[] args) throws SQLException {
		
		//Load and Register the Driver
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//Open connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3305/weja4?user=root&&password=root");
		
		//Create the Statement
		Statement statement = connection.createStatement();
		
		//Execute the Statement
		statement.execute("INSERT INTO user VALUES(1,'GIRISH','girishamrutkar6@gmail.com','Girish@123')");
		
		//Process the Result
		System.out.println("Data Inserted...");
		
		//Close the connection
		statement.close();
		connection.close();

		//DeRegister the Driver
		DriverManager.deregisterDriver(driver);
	}
}
