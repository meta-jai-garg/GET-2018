package problem1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEmployeeCollection {

	/**
	 * test to empty check of employees
	 */
	@Test(expected = AssertionError.class)
	public void TestAddEmployeeEmpty() {
		EmployeeCollection employees = new EmployeeCollection();
		employees.addEmployee("", "", "Jaipur");
	}
	
	/**
	 * test to null check of employees
	 */
	@Test(expected = AssertionError.class)
	public void TestAddEmployeeNull() {
		EmployeeCollection employees = new EmployeeCollection();
		employees.addEmployee(null, "", "Jaipur");
	}

	/**
	 * test to check insertion of employees
	 */
	@Test
	public void TestAddEmployee() {
		EmployeeCollection employees = new EmployeeCollection();
		assertTrue(employees.addEmployee("2", "Jai", "Jaipur"));
		assertTrue(employees.addEmployee("3", "Niraj", "Ajmer"));
		assertTrue(employees.addEmployee("1", "Abhay", "Jodhpur"));
		assertTrue(employees.addEmployee("5", "Twinkle", "Sikar"));
		assertTrue(employees.addEmployee("4", "Namrata", "Delhi"));
	}

	/**
	 * test to get exception for same employee id
	 */
	@Test(expected = AssertionError.class)
	public void TestAddEmployeeException() {
		EmployeeCollection employees = new EmployeeCollection();
		assertTrue(employees.addEmployee("4", "Namrata", "Delhi"));
		employees.addEmployee("4", "Twinkle", "Delhi");
	}

}
