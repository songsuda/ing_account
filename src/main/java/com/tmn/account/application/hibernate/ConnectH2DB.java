package com.tmn.account.application.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectH2DB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			Class.forName("org.h2.Driver");
			connection = DriverManager.getConnection(
					"jdbc:h2:C:/database/test_ing", "sa", "");
			statement = connection.createStatement();
			resultSet = statement
					.executeQuery("select code from account");
			while (resultSet.next()) {
				System.out.println("code :"
						+ resultSet.getString("code"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
