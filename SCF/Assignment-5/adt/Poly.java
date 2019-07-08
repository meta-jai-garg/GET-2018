package adt;

public final class Poly {
	private final int[][] polynomial;
	private static final int COEFF = 0;
	private static final int POWER = 1;

	/**
	 * class constructor
	 * 
	 * @param poly
	 *            is a 2-d array which is receiving coefficient and power of
	 *            polynomial assumes coefficient to be integer
	 */
	public Poly(int[][] poly) {
		if (poly == null || poly.length == 0) {
			throw new AssertionError("Invalid Input!!");
		}
		int row = poly.length;
		polynomial = new int[row][2];
		for (int i = 0; i < row; i++) {
			int duplicate = checkPower(polynomial, poly[i][POWER]);
			if (duplicate != -1) {
				polynomial[duplicate][COEFF] += poly[i][COEFF];
			} else {
				if (poly[i][COEFF] != 0) {
					polynomial[i][COEFF] = poly[i][COEFF];
					polynomial[i][POWER] = poly[i][POWER];
				}
			}
		}
	}

	/**
	 * evaluates current polynomial on the basis of provided value
	 * 
	 * @param varValue
	 *            is{@code Float} variable value for current polynomial
	 * @return evaluated polynomial result
	 */
	public float evaluate(float varValue) {
		float result = 0.0f;
		for (int i = 0; i < polynomial.length; i++) {
			result += polynomial[i][COEFF]
					* Math.pow(varValue, polynomial[i][POWER]);
		}
		return result;
	}

	/**
	 * finds degree of polynomial
	 * 
	 * @return degree of polynomial
	 */
	public int degree() {
		int degree = 0;
		for (int i = 0; i < polynomial.length; i++) {
			if (polynomial[i][POWER] > degree) {
				degree = polynomial[i][POWER];
			}
		}
		return degree;
	}

	/**
	 * This static method adds two {@code Poly} objects
	 * 
	 * @param p1
	 *            is {@code Poly} first object
	 * @param p2
	 *            is {@code Poly} second object
	 * @return new {@code Poly} object containing result of addition
	 */
	public static Poly addPoly(Poly p1, Poly p2) {
		int maxDegree = Math.max(p1.degree(), p2.degree());
		int[][] addition = new int[maxDegree + 1][2];
		int term = 0;
		for (int i = 0; i <= maxDegree; i++) {
			int coeffP1 = p1.getCoeffOfX(i);
			int coeffP2 = p2.getCoeffOfX(i);
			if (coeffP1 != 0 || coeffP2 != 0) {
				addition[term][COEFF] = coeffP1 + coeffP2;
				addition[term][POWER] = i;
				term++;
			}
		}
		return new Poly(addition);
	}

	/**
	 * This static method multiplies two {@code Poly} objects
	 * 
	 * @param p1
	 *            is {@code Poly} first object
	 * @param p2
	 *            is {@code Poly} second object
	 * @return new {@code Poly} object containing result of multiplication
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2) {
		int maxDegree = p1.degree() + p2.degree();
		int[][] multiplication = new int[maxDegree + 1][2];
		int term = 0;
		int[][] firstPolyArray = p1.getPolynomial();
		int[][] secondPolyArray = p2.getPolynomial();
		for (int i = 0; i < firstPolyArray.length; i++) {
			for (int j = 0; j < secondPolyArray.length; j++) {
				int power = firstPolyArray[i][POWER]
						+ secondPolyArray[j][POWER];
				int duplicate = checkPower(multiplication, power);
				if (duplicate != -1) {
					multiplication[duplicate][COEFF] += firstPolyArray[i][COEFF]
							* secondPolyArray[j][COEFF];
				} else {
					multiplication[term][COEFF] = firstPolyArray[i][COEFF]
							* secondPolyArray[j][COEFF];
					multiplication[term][POWER] = power;
					term++;
				}

			}
		}
		return new Poly(multiplication);
	}

	/**
	 * getter method to get Polynomial
	 * 
	 * @return 2-d array that contain polynomial
	 */
	public int[][] getPolynomial() {
		int[][] newPoly = new int[size()][2];
		for (int i = 0; i < size(); i++) {
			newPoly[i][COEFF] = polynomial[i][COEFF];
			newPoly[i][POWER] = polynomial[i][POWER];
		}
		return newPoly;
	}

	/**
	 * helper method to check if power is exist in polynomial or not
	 * 
	 * @param array
	 *            is polynomial
	 * @param pow
	 *            is power to check
	 * @return index if found else -1
	 */
	private static int checkPower(int[][] array, int pow) {
		int duplicate = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i][POWER] == pow) {
				duplicate = i;
				break;
			}
		}
		return duplicate;
	}

	/**
	 * helper method to find coefficient of given power x
	 * 
	 * @param powOfX
	 *            is power
	 * @return coeff of powOfX
	 */
	private int getCoeffOfX(int powOfX) {
		int coeff = 0;
		for (int i = 0; i < polynomial.length; i++) {
			if (polynomial[i][POWER] == powOfX) {
				coeff = polynomial[i][COEFF];
			}
		}
		return coeff;
	}

	/**
	 * helper method to find size of polynomial
	 * 
	 * @return size of polynomial
	 */
	private int size() {
		int size = 0;
		while (size < polynomial.length && polynomial[size][COEFF] != 0) {
			size++;
		}
		return size;
	}
}
