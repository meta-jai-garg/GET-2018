package part2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TestGetValue {
    GetValue getValue = new GetValue();
    List<Object> nestedList = new ArrayList<>();

    @Before
    public void createList() {
        nestedList.add(4);
        nestedList.add(5);
        nestedList.add(7);
        nestedList.add(new ArrayList<>(Arrays.asList(2, 3, 6)));
        List<Object> list1 = new ArrayList<>();
        list1.add(8);
        list1.add(9);
        list1.add(Arrays.asList(1, 11, 32));
        nestedList.add(list1);
    }

    //checks value
    @Test
    public void getValueTest() {
        assertEquals(1, getValue.getValue(nestedList, "TTH"));
        assertEquals(8, getValue.getValue(nestedList, "TH"));
        assertEquals(4, getValue.getValue(nestedList, "H"));

    }

    //checks for exception when specified string is not appropriate
    @Test(expected = AssertionError.class)
    public void getValueThrowsExceptionTest() {
        getValue.getValue(nestedList, "HT");
        getValue.getValue(nestedList, "TTTT");
        getValue.getValue(nestedList, "THT");
        getValue.getValue(nestedList, "TTHT");

    }

    //when specifiedPosition string contains character other than T or H
    @Test(expected = IllegalStateException.class)
    public void getValueThrowsIllegealStateExceptionTest() {
        getValue.getValue(nestedList, "TF");
    }

    //when nested list is empty
    @Test(expected = NullPointerException.class)
    public void getValueThrowsExceptionIfListIsEmpty() {
        List<Object> nestedList = new ArrayList<>();
        getValue.getValue(nestedList, "HT");
    }

    //when specified position string is empty
    @Test(expected = AssertionError.class)
    public void getValueThrowsExceptionIfSpecifiedPositionIsEmpty() {
        getValue.getValue(nestedList, "");
    }
}
