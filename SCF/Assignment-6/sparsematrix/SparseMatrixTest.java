package sparsematrix;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SparseMatrixTest {

	@Test(expected = AssertionError.class)
	public void nullCheck() {
		new SparseMatrix(null);
	}

	@Test
	public void transposeTestPositive1() {
		int[][] sparseMatrix = new int[][] { { 0, 1, 2 }, { 0, 3, 4 },
				{ 0, 5, 6 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] expected = new int[][] { { 0, 0, 0 }, { 1, 3, 5 }, { 2, 4, 6 } };
		assertArrayEquals(expected, s.transpose());
	}

	@Test
	public void transposeTestPositive2() {
		int[][] sparseMatrix = new int[][] { { 0, 1, 2 }, { 0, 3, 4 },
				{ 0, 5, 6 }, { 0, 7, 8 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] expected = new int[][] { { 0, 0, 0, 0 }, { 1, 3, 5, 7 },
				{ 2, 4, 6, 8 } };
		assertArrayEquals(expected, s.transpose());
	}

	@Test
	public void isSymmetricPositive() {
		int[][] sparseMatrix = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		assertEquals(true, s.isSymmetric());
	}

	@Test
	public void isSymmetricNegative() {
		int[][] sparseMatrix = { { 1, 1, 0 }, { 0, 1, 1 }, { 1, 0, 1 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		assertEquals(false, s.isSymmetric());
	}

	@Test
	public void isSymmetricSpecial() {
		int[][] sparseMatrix = { { 1, 1, 0, 4 }, { 4, 0, 1, 1 }, { 5, 1, 0, 1 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		assertEquals(false, s.isSymmetric());
	}

	@Test
	public void additionTestPositive() {
		int[][] sparseMatrix = new int[][] { { 0, 1, 2 }, { 0, 3, 4 },
				{ 0, 5, 6 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] actual = s.addMatrix(new int[][] { { 1, 1, 1 }, { 1, 1, 1 },
				{ 1, 1, 1 } });
		int[][] expected = new int[][] { { 1, 2, 3 }, { 1, 4, 5 }, { 1, 6, 7 } };
		assertArrayEquals(expected, actual);
	}

	@Test(expected = AssertionError.class)
	public void additionTestNegative() {
		int[][] sparseMatrix = new int[][] { { 0, 1, 2 }, { 0, 3, 4 },
				{ 0, 5, 6 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] actual = s
				.addMatrix(new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 } });
		assertArrayEquals(new int[][] {}, actual);
	}

	@Test
	public void multiplicationTestPositive1() {
		int[][] sparseMatrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] actual = s.multiply(new int[][] { { 7, 8 }, { 9, 10 },
				{ 11, 12 } });
		int[][] expected = new int[][] { { 58, 64 }, { 139, 154 } };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void multiplicationTestPositive2() {
		int[][] sparseMatrix = new int[][] { { 1, 2 }, { 3, 4 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] actual = s.multiply(new int[][] { { 2, 0 }, { 1, 2 } });
		int[][] expected = new int[][] { { 4, 4 }, { 10, 8 } };
		assertArrayEquals(expected, actual);
	}

	@Test(expected = AssertionError.class)
	public void multiplicationTestNegative() {
		int[][] sparseMatrix = new int[][] { { 1, 2 }, { 4, 5 } };
		SparseMatrix s = new SparseMatrix(sparseMatrix);
		int[][] actual = s.multiply(new int[][] { { 7, 8 }, { 9, 10 },
				{ 11, 12 } });
		int[][] expected = new int[][] {};
		assertArrayEquals(expected, actual);
	}
}
