package problem2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterCount {
	private static Map<String, Integer> map = new HashMap<String, Integer>();

	/**
	 * method to find unique character in string
	 * 
	 * @param string
	 *            is an object of string
	 * @return count of unique character
	 */
	public static int countUniqueCharacter(String string) {
		if ("".equals(string) || string == null) {
			throw new AssertionError("Invalid Input");
		}
		if (map.containsKey(string)) {
			return map.get(string);
		} else {
			updateCache(string);
			return map.get(string);
		}
	}

	/**
	 * helper method to increase efficiency
	 * 
	 * @param str
	 *            is object of string
	 */
	private static void updateCache(String str) {
		char[] stringSet = str.toCharArray();
		Set<Character> set = new HashSet<Character>();
		int i = 0;
		while (i < stringSet.length) {
			set.add(stringSet[i]);
			i++;
		}
		map.put(str, set.size());
	}
}
