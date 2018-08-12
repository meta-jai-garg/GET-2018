package viratmatch;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class TestBowlingOrder {
    Map<String, Integer> bowlerMap;

    /**
     * this test case is used to  create and initialize the bowler map
     */
    @Before
    public void createObject() {
        bowlerMap = new LinkedHashMap<String, Integer>();

        bowlerMap.put("Bhuvnesh", 7);
        bowlerMap.put("Ishant", 9);
        bowlerMap.put("Bumrah", 5);
    }


    /**
     * test case for testing the bowling order returned by the BowlingOrder() method
     */
    @Test
    public void BowlingOrderTest1() {
        BowlingOrder BowlingOrder = new BowlingOrder(10, bowlerMap);
        List<String> expectedBowlingOrder = new ArrayList<String>(Arrays.asList("Ishant", "Ishant", "Bhuvnesh", "Ishant", "Bhuvnesh", "Ishant", "Bhuvnesh", "Ishant", "Bumrah", "Bhuvnesh"));
        assertEquals(expectedBowlingOrder, BowlingOrder.bowlingOrder());
    }


    /**
     * test case when no of balls that virat would play is greater than the number of balls the bowlers can bowl combined
     */
    @Test(expected = AssertionError.class)
    public void BowlingOrderTest2() {

        new BowlingOrder(40, bowlerMap);
    }


    /**
     * test case when no of balls that virat would play is negative
     */
    @Test(expected = AssertionError.class)
    public void BowlingOrderTest4() {

        new BowlingOrder(-20, bowlerMap);
    }


    /**
     * test case when no of balls that virat would play is 0
     */
    @Test(expected = AssertionError.class)
    public void BowlingOrderTest5() {

        new BowlingOrder(0, bowlerMap);
    }


    /**
     * test case when no of balls to be bowled by a bowler is negative
     */
    @Test(expected = AssertionError.class)
    public void BowlingOrderTest6() {

        Map<String, Integer> newBowlerMap = new LinkedHashMap<String, Integer>();

        newBowlerMap.put("Jai", 7);
        newBowlerMap.put("Abhay", 9);
        newBowlerMap.put("Niraj", -2);
        new BowlingOrder(10, newBowlerMap);
    }
}
