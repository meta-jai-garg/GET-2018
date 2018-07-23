package recursion;

public class NQueen {
    /**
     * This method checks if a queen can be placed on chessBoard[row][column]
     *
     * @param chessBoard is 2-d array that represents the queen's placing on chess
     *                   board
     * @param row        is place in matrix
     * @param column     is place in matrix
     * @return true if it finds safer place for queen else false
     */
    private boolean isQueenSafe(int[][] chessBoard, int row, int column) {
        for (int i = 0; i < chessBoard.length; i++) {
            if (chessBoard[row][i] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        for (int i = row, j = column; j >= 0 && i < chessBoard.length; i++, j--) {
            if (chessBoard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method finds placing of N queen in a N*N chess board.
     *
     * @param chessBoard is a 2-d for representation of chess board
     * @param column     is a starting index where the placing starts
     * @return true if it finds placing for all the N queens else false
     */
    boolean solveNQueenProblem(int[][] chessBoard, int column) {
        if (column >= chessBoard.length) {
            return true;
        }
        for (int i = 0; i < chessBoard.length; i++) {
            if (isQueenSafe(chessBoard, i, column)) {
                chessBoard[i][column] = 1;
                if (solveNQueenProblem(chessBoard, column + 1))
                    return true;
                chessBoard[i][column] = 0;
            }
        }
        return false;
    }
}
