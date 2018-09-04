package com.meta.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DbUtil {

	private static final String DB = "ads";
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/" + DB;
	private static final String USER = "root";
	private static final String PASSWORD = "12345";

	/**
	 * Method to create database connection
	 * @return {@link Connection} object
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_DRIVER);
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
