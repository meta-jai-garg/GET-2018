package adt;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {

	/**
	 * test for null check
	 */
	@Test(expected = AssertionError.class)
	public void nullCheck() {
		new Poly(null);
	}

	/**
	 * test for empty check
	 */
	@Test(expected = AssertionError.class)
	public void emptyCheck() {
		new Poly(new int[][] {});
	}

	/**
	 * test for polynomial evaluation
	 */
	@Test
	public void evaluateTest1() {
		Poly polynomial = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 }, { 4, 1 } });
		float result = polynomial.evaluate(2f);
		assertEquals(24, result, 0.001);
		Poly polynomial1 = new Poly(new int[][] { { 5, 2 }, { 3, 1 }, { 2, 0 } });
		float result1 = polynomial1.evaluate(2f);
		assertEquals(28, result1, 0.001);
	}

	/**
	 * test to check degree of polynomial
	 */
	@Test
	public void degreeTest() {
		Poly polynomial = new Poly(new int[][] { { 2, 3 }, { 3, 1 }, { 2, 0 }, { 4, 1 } });
		int degree = polynomial.degree();
		assertEquals(3, degree);
		Poly polynomial1 = new Poly(new int[][] { { 5, 2 }, { 3, 1 }, { 2, 0 } });
		int degree1 = polynomial1.degree();
		assertEquals(2, degree1);
	}

	/**
	 * test to check addition of two {@code Poly} objects
	 */
	@Test
	public void addPolyTest() {
		Poly poly1 = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 } });
		Poly poly2 = new Poly(new int[][] { { 4, 3 }, { 3, 1 } });

		Poly result = Poly.addPoly(poly1, poly2);
		assertArrayEquals(new int[][] { { 2, 0 }, { 6, 1 }, { 2, 2 }, { 4, 3 } }, result.getPolynomial());
		Poly poly3 = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 } });
		Poly poly4 = new Poly(new int[][] { { 4, 3 }, { 3, 1 }, { 2, 2 } });

		Poly result1 = Poly.addPoly(poly3, poly4);
		assertArrayEquals(
				new int[][] { { 2, 0 }, { 6, 1 }, { 4, 2 }, { 4, 3 } },
				result1.getPolynomial());
	}

	/**
	 * test to check multiplication of two {@code Poly} objects
	 */
	@Test
	public void multiplyPolyTest() {
		Poly poly1 = new Poly(new int[][] { { 2, 2 }, { 3, 1 }, { 2, 0 } });
		Poly poly2 = new Poly(new int[][] { { 4, 3 }, { 3, 1 } });

		Poly result = Poly.multiplyPoly(poly1, poly2);
		assertArrayEquals(new int[][] { { 8, 5 }, { 14, 3 }, { 12, 4 }, { 9, 2 }, { 6, 1 } }, result.getPolynomial());
		Poly poly3 = new Poly(new int[][] { { 1, 2 }, { 1, 1 } });
		Poly poly4 = new Poly(new int[][] { { 2, 1 }, { 1, 0 } });

		Poly result1 = Poly.multiplyPoly(poly3, poly4);
		assertArrayEquals(new int[][] { { 2, 3 }, { 3, 2 }, { 1, 1 } }, result1.getPolynomial());
	}

}
