package problem1;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
	private String id, name, address;

	/**
	 * @param id
	 *            of employee
	 * @param name
	 *            of employee
	 * @param address
	 *            of employee
	 */
	public Employee(String id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public int compareTo(Employee employee) {
		return id.compareTo(employee.getId());
	}

	/**
	 * to sort on {{@link Employee}'s name attribute
	 */
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
	};

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address
				+ "]";
	}
}