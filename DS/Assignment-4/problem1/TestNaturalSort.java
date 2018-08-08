package problem1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TestNaturalSort {

	/**
	 * test to check sorting by name
	 */
	@Test
	public void testNaturalSort() {
		EmployeeCollection employees = new EmployeeCollection();
		assertTrue(employees.addEmployee("2", "Jai", "Jaipur"));
		assertTrue(employees.addEmployee("3", "Niraj", "Ajmer"));
		assertTrue(employees.addEmployee("1", "Abhay", "Jodhpur"));
		assertTrue(employees.addEmployee("5", "Twinkle", "Sikar"));
		assertTrue(employees.addEmployee("4", "Namrata", "Delhi"));

		Map<String, Employee> employeeDetails = employees.getEmployeeDetails();

		List<Employee> actual = new ArrayList<Employee>();
		actual.add(new Employee("1", "Abhay", "Jodhpur"));
		actual.add(new Employee("2", "Jai", "Jaipur"));
		actual.add(new Employee("3", "Niraj", "Ajmer"));
		actual.add(new Employee("4", "Namrata", "Delhi"));
		actual.add(new Employee("5", "Twinkle", "Sikar"));
		List<Employee> expected = NaturalSort.naturalSort(employeeDetails);

		for (int i = 0; i < expected.size(); i++) {
			assertEquals(expected.get(i).toString(), actual.get(i).toString());
		}
	}
}
