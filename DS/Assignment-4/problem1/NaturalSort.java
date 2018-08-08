package problem1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class NaturalSort {

	/**
	 * method to sort {@link Employee} in natural order i.e. on their id
	 * @param employeeList is a Map
	 * @return list of sorted employees
	 */
	public static List<Employee> naturalSort(Map<String, Employee> employeeList) {
		List<Employee> sortedList = new ArrayList<Employee>(employeeList.values());
		Collections.sort(sortedList);
		return sortedList;
	}
}
