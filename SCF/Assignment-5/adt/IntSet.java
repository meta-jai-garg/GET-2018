package adt;

import java.util.Arrays;

public final class IntSet {
	private final int[] setElements;

	/**
	 * constructor
	 * 
	 * @param setArray
	 *            is elements of IntSet
	 * @throws AssertionError
	 *             in case of null input
	 */
	public IntSet(int[] setArray) {
		if (setArray == null) {
			throw new AssertionError("Invalid input");
		} else if (setArray.length == 0) {
			this.setElements = new int[] {};
		} else {
			Arrays.sort(setArray);
			int[] tempArray = removeDuplicates(setArray);
			int nonZeroLength = 0;
			for (int i = 0; i < tempArray.length; i++) {
				if (tempArray[i] != 0) {
					nonZeroLength++;
				}
			}
			this.setElements = new int[nonZeroLength];
			for (int i = 0; i < nonZeroLength; i++) {
				setElements[i] = tempArray[i];
			}
		}
	}

	/**
	 * checks weather x is member of set or not
	 * 
	 * @param x
	 *            is {@code Integer}
	 * @return true if x is member of IntSet else false
	 */
	public boolean isMember(int x) {
		if (x <= 0 || x > 1000) {
			return false;
		} else {
			int i = 0;
			while (i < size()) {
				if (setElements[i] == x) {
					return true;
				}
				i++;
			}
		}
		return false;
	}

	/**
	 * checks weather the given IntSet is subset of current IntSet or not
	 * 
	 * @param s
	 *            is {@code IntSet} object
	 * @return true if s is the subset of current object
	 */
	public boolean isSubSet(IntSet s) {
		boolean isSubSet = false;
		int[] tempSet = s.getSetElements();
		if (s.size() == 0) {
			isSubSet = true;
		}
		int j = 0;
		if (this.size() >= s.size()) {
			for (int i = 0; i < this.size(); i++) {
				if (j < s.size()) {
					isSubSet = false;
				} else {
					break;
				}
				if (setElements[i] == tempSet[j]) {
					isSubSet = true;
					j++;
				}
			}
		}
		return isSubSet;
	}

	/**
	 * finds size of current IntSet object
	 * 
	 * @return size of IntSet object
	 */
	public int size() {
		return setElements.length;
	}

	/**
	 * finds compliment of current IntSet considering universal set in range
	 * 1-1000
	 * 
	 * @return complement of IntSet
	 */
	public IntSet getCompliment() {
		int[] complement = new int[1000 - this.size()];
		int j = 0;
		for (int i = 1; i <= 1000; i++) {
			if (!this.isMember(i)) {
				complement[j++] = i;
			}
		}
		return new IntSet(complement);
	}

	/**
	 * finds union of two IntSet
	 * 
	 * @param s1
	 *            is {@code IntSet} object of first IntSet
	 * @param s2
	 *            is {@code IntSet} object of second IntSet
	 * @return new IntSet containing union of s1 and s2
	 */
	public static IntSet union(IntSet s1, IntSet s2) {
		int[] setFirst = s1.getSetElements();
		int[] setSecond = s2.getSetElements();
		int[] union = new int[setFirst.length + setSecond.length];
		int j = 0;
		for (int i = 0; i < setFirst.length; i++) {
			union[j++] = setFirst[i];
		}
		for (int i = 0; i < setSecond.length; i++) {
			union[j++] = setSecond[i];
		}
		return new IntSet(union);
	}

	/**
	 * helper method to remove duplicate elements from array
	 * 
	 * @param array
	 * @return unique array
	 */
	private int[] removeDuplicates(int[] array) {
		int[] newArray = new int[array.length];
		int j = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i + 1]) {
				newArray[j++] = array[i];
			}
		}
		newArray[j++] = array[array.length - 1];
		return newArray;
	}

	/**
	 * @return elements of current IntSet object
	 */
	public int[] getSetElements() {
		return setElements;
	}

}
