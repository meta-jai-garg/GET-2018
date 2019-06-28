package recursion;

import org.junit.Assert;
import org.junit.Test;

public class NQueenTest {
    @Test
    public void solveNQueenProblem() {
        NQueen nQueen = new NQueen();
        int[][] chessBoardFirst = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        Assert.assertEquals("Failure", true, nQueen.solveNQueenProblem(chessBoardFirst, 0));
        for (int[] aChessBoardFirst : chessBoardFirst) {
            for (int j = 0; j < chessBoardFirst.length; j++) {
                System.out.print(" " + aChessBoardFirst[j]);
            }
            System.out.println();
        }
        int[][] chessBoardSecond = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        Assert.assertEquals("Failure", false, nQueen.solveNQueenProblem(chessBoardSecond, 0));
        int[][] chessBoardThird = {
                {0, 0},
                {0, 0}
        };
        Assert.assertEquals("Failure", false, nQueen.solveNQueenProblem(chessBoardThird, 0));
    }
}
