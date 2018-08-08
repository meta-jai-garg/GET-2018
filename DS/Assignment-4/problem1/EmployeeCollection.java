package problem1;

import java.util.HashMap;
import java.util.Map;

public class EmployeeCollection {
	/**
	 * map to store employee details
	 */
	private Map<String, Employee> employeeDetails = new HashMap<String, Employee>();

	/**
	 * method to add employee details
	 * 
	 * @param empId
	 *            of employee
	 * @param name
	 *            of employee
	 * @param address
	 *            of employee
	 * @return true when employee is added
	 */
	public boolean addEmployee(String empId, String name, String address) {
		if ("".equals(empId) || empId == null
				|| "".equals(name) || name == null
				|| "".equals(address) || address == null) {
			throw new AssertionError("Invalid input!!");
		}

		boolean isAdded = false;
		if (employeeDetails.containsKey(empId)) {
			throw new AssertionError("Employee already exist");
		} else {
			employeeDetails.put(empId, new Employee(empId, name, address));
			isAdded = true;
		}
		return isAdded;
	}

	public Map<String, Employee> getEmployeeDetails() {
		return employeeDetails;
	}

}
