package part1.infixtopostfix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConversion {
    @Test
    public void testInfixToPostfix1() {
        String actualResult = Conversion.infixToPostfix("A + ( B * C - ( D / E - F ) * G ) * H");
        String expectedResult = "A B C * D E / F - G * - H * +";
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testInfixToPostfix2() {
        String actualResult = Conversion.infixToPostfix("ab + b * ( c ^ d - e ) ^ ( f + g ^ h ) - i");
        String expectedResult = "ab b c d ^ e - f g h ^ + ^ * + i -";
        assertEquals(expectedResult, actualResult);
    }


    //expression invalid case


    @Test(expected = AssertionError.class)
    public void testInfixToPostfix3() {
        Conversion.infixToPostfix("(( D / E - F )");
    }

    @Test(expected = AssertionError.class)
    public void testInfixToPostfix4() {
        Conversion.infixToPostfix("a + b -");
    }
}
