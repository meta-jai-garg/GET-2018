package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.util.DbUtil;

/**
 * Data Access Object to perform query functions
 * 
 * @author User22
 *
 */
public class EmployeeDAO {

	private static EmployeeDAO dao = new EmployeeDAO();

	public static EmployeeDAO getInstance() {
		return dao;
	}

	/**
	 * method to insert data in employee
	 * 
	 * @param employee
	 *            an object of {@code Employee}
	 * @return 1 if added else -1 in case of constraint fail else 0
	 */
	public int addEmployee(Employee employee) {
		int affectedRow = 0;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(Query.INSERT_EMPLOYEE);) {
			conn.setAutoCommit(false);
			stmt.setString(1, employee.getFirstName());
			stmt.setString(2, employee.getLastName());
			stmt.setDate(3, employee.getDob());
			stmt.setString(4, employee.getMobile());
			stmt.setString(5, employee.getEmail());
			stmt.setString(6, employee.getPassword());
			stmt.setString(7, employee.getOrganization());
			affectedRow = stmt.executeUpdate();
			conn.commit();
		} catch (MySQLIntegrityConstraintViolationException e) {
			affectedRow = -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return affectedRow;
	}

	// /**
	// * method to get all employees
	// *
	// * @return list of {@code Employee} object
	// */
	// public List<Employee> getEmployee() {
	// List<Employee> employees = new ArrayList<Employee>();
	// try (Connection conn = DbUtil.getConnection();
	// PreparedStatement stmt = conn
	// .prepareStatement(Query.GET_EMPLOYEE);) {
	// ResultSet employeeSet = stmt.executeQuery();
	// while (employeeSet.next()) {
	// Employee employee = new Employee();
	// employee.setId(employeeSet.getInt("id"));
	// employee.setFirstName(employeeSet.getString("firstName"));
	// employee.setLastName(employeeSet.getString("lastName"));
	// employee.setEmail(employeeSet.getString("email"));
	// employee.setAge(employeeSet.getInt("age"));
	// employees.add(employee);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return employees;
	// }
	//
	// /**
	// * method to get list of employee according to name
	// *
	// * @param name
	// * of employee
	// * @return list of {@link Employee}
	// */
	// public List<Employee> getEmployee(String name) {
	// List<Employee> employees = new ArrayList<Employee>();
	// try (Connection conn = DbUtil.getConnection();
	// PreparedStatement stmt = conn
	// .prepareStatement(Query.GET_EMPLOYEE_BY_NAME);) {
	// stmt.setString(1, "%" + name + "%");
	// ResultSet employeeSet = stmt.executeQuery();
	// while (employeeSet.next()) {
	// Employee employee = new Employee();
	// employee.setId(employeeSet.getInt("id"));
	// employee.setFirstName(employeeSet.getString("firstName"));
	// employee.setLastName(employeeSet.getString("lastName"));
	// employee.setEmail(employeeSet.getString("email"));
	// employee.setAge(employeeSet.getInt("age"));
	// employees.add(employee);
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return employees;
	// }
	//
	/**
	 * method to get employee details
	 *
	 * @param id
	 *            of employee
	 * @return {@code Employee}
	 */
	public Employee getEmployee(String email) {
		Employee employee = null;
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(Query.GET_EMPLOYEE_BY_EMAIL);) {
			stmt.setString(1, email);
			ResultSet employeeSet = stmt.executeQuery();
			if (employeeSet.next()) {
				employee = new Employee();
				employee.setFirstName(employeeSet.getString("firstName"));
				employee.setLastName(employeeSet.getString("lastName"));
				employee.setDob(employeeSet.getDate("dob"));
				employee.setAge(employeeSet.getInt("age"));
				employee.setMobile(employeeSet.getString("mobile"));
				employee.setEmail(employeeSet.getString("email"));
				employee.setPassword(employeeSet.getString("password"));
				employee.setOrganization(employeeSet.getString("organization"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List<Employee> getEmployee(String organization, String email) {
		List<Employee> emploList = new ArrayList<Employee>();
		try (Connection conn = DbUtil.getConnection();
				PreparedStatement stmt = conn
						.prepareStatement(Query.GET_EMPLOYEE_BY_ORGANIZATION);) {
			stmt.setString(1, organization);
			stmt.setString(2, email);
			ResultSet employeeSet = stmt.executeQuery();
			while (employeeSet.next()) {
				Employee employee = new Employee();
				employee.setFirstName(employeeSet.getString("name"));
				employee.setEmail(employeeSet.getString("email"));
				emploList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emploList;
	}
	//
	// /**
	// * method to update employee details
	// *
	// * @param employee
	// * an object of {@link Employee}
	// * @return 1 if updated, -1 if integrity constraint fails, else 0
	// */
	// public int updateEmployee(Employee employee) {
	// int result = 0;
	// try (Connection conn = DbUtil.getConnection();
	// PreparedStatement stmt = conn
	// .prepareStatement(Query.UPDATE_EMPLOYEE);) {
	// stmt.setString(1, employee.getFirstName());
	// stmt.setString(2, employee.getLastName());
	// stmt.setString(3, employee.getEmail());
	// stmt.setInt(4, employee.getAge());
	// stmt.setInt(5, employee.getId());
	// result = stmt.executeUpdate();
	// } catch (MySQLIntegrityConstraintViolationException e) {
	// result = -1;
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return result;
	// }
}