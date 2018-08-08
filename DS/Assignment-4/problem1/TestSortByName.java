package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestSortByName {

	/**
	 * test to check natural sort
	 */
	@Test
	public void testSortByName() {
		EmployeeCollection employees = new EmployeeCollection();
		assertTrue(employees.addEmployee("2", "Jai", "Jaipur"));
		assertTrue(employees.addEmployee("3", "Abhay", "Ajmer"));
		assertTrue(employees.addEmployee("1", "Niraj", "Jodhpur"));
		assertTrue(employees.addEmployee("5", "Twinkle", "Sikar"));
		assertTrue(employees.addEmployee("4", "Namrata", "Delhi"));

		Map<String, Employee> employeeDetails = employees.getEmployeeDetails();

		List<Employee> expected = SortByName.sortByName(employeeDetails);
		
		List<Employee> actual = new ArrayList<Employee>();
		actual.add(new Employee("3", "Abhay", "Ajmer"));
		actual.add(new Employee("2", "Jai", "Jaipur"));
		actual.add(new Employee("4", "Namrata", "Delhi"));
		actual.add(new Employee("1", "Niraj", "Jodhpur"));
		actual.add(new Employee("5", "Twinkle", "Sikar"));
		

		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).toString(), actual.get(i).toString());
		}
	}

}
