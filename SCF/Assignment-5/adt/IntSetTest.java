package adt;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {

	@Test
	public void isMemberTest() {
		IntSet intSet = new IntSet(new int[] { 1, 2, 2, 3, 3, 4, 1000 });
		/**
		 * positive test case
		 */
		assertTrue(intSet.isMember(3));
		assertTrue(intSet.isMember(1000));
		/**
		 * negative test case
		 */
		assertFalse(intSet.isMember(5));
		assertFalse(intSet.isMember(-1));
		assertFalse(intSet.isMember(0));

	}

	@Test(expected = AssertionError.class)
	public void sizeTest() {
		IntSet intSet;

		/**
		 * positive test
		 */
		intSet = new IntSet(new int[] { 1, 2, 2, 3, 3, 4, 1000 });
		assertEquals(5, intSet.size());
		intSet = new IntSet(new int[] {});
		assertEquals(0, intSet.size());

		/**
		 * null case
		 */
		intSet = new IntSet(null);
	}

	@Test
	public void isSubSetTest() {
		IntSet set1;
		IntSet set2;

		/**
		 * positive test case
		 */
		set1 = new IntSet(new int[] { 1, 2, 3, 4 });
		set2 = new IntSet(new int[] { 1, 2 });
		assertTrue(set1.isSubSet(set2));
		/**
		 * negative test case
		 */
		set1 = new IntSet(new int[] { 1, 2, 3, 4 });
		set2 = new IntSet(new int[] { 1, 2, 5, 4, 5, 6, 7 });
		assertFalse(set1.isSubSet(set2));
	}

	@Test
	public void getComplimentTest() {
		IntSet set = new IntSet(new int[] { 1, 2, 4, 3, 5 });
		IntSet complement = set.getCompliment();
		assertEquals(995, complement.size());
	}

	@Test
	public void unionTest() {
		IntSet set1 = new IntSet(new int[] { 1, 2, 3, 4 });
		IntSet set2 = new IntSet(new int[] { 1, 2 });
		IntSet union = IntSet.union(set1, set2);
		assertArrayEquals(new int[] { 1, 2, 3, 4 }, union.getSetElements());

	}
}