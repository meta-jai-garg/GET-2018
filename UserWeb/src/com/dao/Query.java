package com.dao;

/**
 *Class to hold queries for database.
 */
public class Query {
	public static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE(firstName, lastName, dob, mobile, email, password, organization)VALUE(?,?,?,?,?,?,?)";
	public static final String GET_EMPLOYEE_BY_EMAIL = "SELECT firstName, lastName, dob,TIMESTAMPDIFF(YEAR,dob, CURDATE()) AS age, mobile, email, password, organization FROM EMPLOYEE WHERE email=?";
	public static final String GET_EMPLOYEE_BY_ORGANIZATION = "SELECT CONCAT(firstName,' ', lastName) AS name, email FROM EMPLOYEE WHERE organization = ? AND email != ?";
	public static final String UPDATE_EMPLOYEE = "UPDATE employee SET firstName=?, lastName = ?, dob=?, mobile=?, password=?, organzation=? WHERE email = ?";
}