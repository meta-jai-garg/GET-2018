package com.dao;

/**
 *Class to hold queries for database.
 */
public class Query {
	public static final String INSERT_EMPLOYEE = "INSERT INTO employee(firstName, lastName, email, age)VALUE(?,?,?,?)";
	public static final String GET_EMPLOYEE = "SELECT id, firstName, lastName, email, age FROM EMPLOYEE";
	public static final String GET_EMPLOYEE_BY_NAME = "SELECT id, firstName, lastName, email, age FROM EMPLOYEE WHERE CONCAT(firstName,' ',lastName) LIKE ?";
	public static final String SEARCH_EMPLOYEE_BY_ID = "SELECT firstName, lastName, email, age FROM EMPLOYEE WHERE id = ?";
	public static final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName=?, lastName = ?, email = ?, age = ? WHERE id = ?";
}
