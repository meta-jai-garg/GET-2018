package part1.postfixevaluation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPostfixEvaluation {

    @Test
    public void testEvaluateExpression1() {
        PostfixEvaluation eval = new PostfixEvaluation();
        int result = eval.evaluate("10 12 * 9 13 * + 11 -");
        assertEquals(226, result);
    }

    @Test
    public void testEvaluateExpression2() {
        PostfixEvaluation eval = new PostfixEvaluation();
        int result = eval.evaluate("10 5 / 3 +");
        assertEquals(5, result);
    }

    /**
     * exception case when divide by zero occurs
     */
    @Test(expected = AssertionError.class)
    public void testEvaluateExpression3() {
        PostfixEvaluation eval = new PostfixEvaluation();
        eval.evaluate("10 0 / 3 +");
    }

    /**
     * when expression is invalid
     */
    @Test(expected = AssertionError.class)
    public void testEvaluateExpression4() {
        PostfixEvaluation eval = new PostfixEvaluation();
        try {
            @SuppressWarnings("unused")
            int result = eval.evaluate("10 12 % 9 13 * + 11 -");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
