package sparsematrix;

public final class SparseMatrix {
	private final int[][] finalSparseMatrix;
	private final int matRow;
	private final int matCol;
	private final int sparseCol;

	/**
	 * It's a class constructor
	 * 
	 * @param sparseMatrix
	 *            is 2-d array
	 */
	public SparseMatrix(int[][] sparseMatrix) {
		if (sparseMatrix == null) {
			throw new AssertionError("Invalid input");
		}
		matRow = sparseMatrix.length;
		matCol = sparseMatrix[0].length;
		finalSparseMatrix = convertToSparse(sparseMatrix);
		sparseCol = finalSparseMatrix[0].length;
	}

	/**
	 * This method finds the transpose of matrix
	 * 
	 * @return transpose of a matrix
	 */
	public int[][] transpose() {
		int[][] transposedMatrix = new int[matCol][matRow];
		for (int i = 0; i < sparseCol; i++) {
			transposedMatrix[finalSparseMatrix[1][i]][finalSparseMatrix[0][i]] = finalSparseMatrix[2][i];
		}
		return transposedMatrix;
	}

	/**
	 * This method checks the symmetry of a matrix
	 * 
	 * @return true if matrix is symmetric
	 */
	public boolean isSymmetric() {
		if (matRow != matCol) {
			return false;
		}
		int[][] temp = this.transpose();
		for (int i = 0; i < finalSparseMatrix[0].length; i++) {
			if (temp[finalSparseMatrix[0][i]][finalSparseMatrix[1][i]] != finalSparseMatrix[2][i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method finds addition of two matrices
	 * 
	 * @param matrix
	 *            is 2-D array i.e. the array to be added
	 * @return addition of two matrix
	 * @throws AssertionError
	 *             in case of invalid @param matrix
	 */
	public int[][] addMatrix(int[][] matrix) {
		if (matRow != matrix.length || matCol != matrix[0].length) {
			throw new AssertionError(
					"Can't add matrix with different dimension");
		}
		int[][] result = matrix.clone();
		for (int i = 0; i < sparseCol; i++) {
			result[finalSparseMatrix[0][i]][finalSparseMatrix[1][i]] += finalSparseMatrix[2][i];
		}
		return result;
	}

	/**
	 * This method finds multiplication of two matrices
	 * 
	 * @param matrix
	 *            is 2-D array i.e. the array to be multiplied
	 * @return multiplication of two matrix
	 * @throws AssertionError
	 *             in case of invalid @param matrix
	 */
	public int[][] multiply(int[][] matrix) {
		if (matCol != matrix.length) {
			throw new AssertionError("Matrix is not valid for multiplication");
		}
		int[][] oldMatrix = convertToNormal();
		int[][] result = new int[matRow][matrix[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				for (int k = 0; k < matCol; k++) {
					result[i][j] += oldMatrix[i][k] * matrix[k][j];
				}
			}
		}
		return result;
	}

	/**
	 * This is a helper method to convert a normal matrix to sparse matrix
	 * 
	 * @param sparseMatrix2
	 *            is a 2-D array i.e. going to converted in sparse
	 * @return converted sparse matrix
	 */
	private int[][] convertToSparse(int[][] sparseMatrix2) {
		int size = 0;
		for (int i = 0; i < sparseMatrix2.length; i++) {
			for (int j = 0; j < sparseMatrix2[i].length; j++) {
				if (sparseMatrix2[i][j] != 0) {
					size++;
				}
			}
		}
		int[][] tempSparseMatrix = new int[3][size];
		int k = 0;
		for (int row = 0; row < sparseMatrix2.length; row++) {
			for (int col = 0; col < sparseMatrix2[row].length; col++) {
				if (sparseMatrix2[row][col] != 0) {
					tempSparseMatrix[0][k] = row;
					tempSparseMatrix[1][k] = col;
					tempSparseMatrix[2][k] = sparseMatrix2[row][col];
					k++;
				}
			}
		}
		return tempSparseMatrix;
	}

	/**
	 * This is a helper method to convert a sparse matrix to normal matrix
	 * 
	 * @param sparseMatrix2
	 *            is a 2-D array i.e. going to converted in sparse
	 * @return converted normal matrix
	 */
	private int[][] convertToNormal() {
		int[][] normalMatrix = new int[matRow][matCol];
		for (int i = 0; i < sparseCol; i++) {
			normalMatrix[finalSparseMatrix[0][i]][finalSparseMatrix[1][i]] = finalSparseMatrix[2][i];
		}
		return normalMatrix;
	}

}
