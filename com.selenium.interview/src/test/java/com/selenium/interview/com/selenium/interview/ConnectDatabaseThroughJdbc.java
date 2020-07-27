package com.selenium.interview.com.selenium.interview;

import java.sql.*;

import org.testng.annotations.Test;

public class ConnectDatabaseThroughJdbc {

	@Test
	public void establishConnection() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "Student",
					"Student");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from employees");
			while (resultSet.next()) {
				System.out.println(resultSet.getString("FirstName") + " " + resultSet.getString("FirstName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}