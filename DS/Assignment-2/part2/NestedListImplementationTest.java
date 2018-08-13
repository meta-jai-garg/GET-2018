package part2;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class NestedListImplementationTest {
    NestedListImplementation implementation = new NestedListImplementation();
    JSONReader jsonObject = new JSONReader();

    /**
     * test for sum method
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void sumTest() throws IOException, ParseException {

        JSONObject object = jsonObject.createJsonObject();
        NestedLinkedList nestedList = jsonObject.storeJsonNestedObjectIntoNestedList(object);
        assertEquals(73, implementation.sum(nestedList.getNestedList()));
        assertNotEquals(23, implementation.sum(nestedList.getNestedList()));
    }

    /**
     * test for largestValue method
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void largestValueTest() throws IOException, ParseException {
        JSONObject object = jsonObject.createJsonObject();
        NestedLinkedList nestedList = jsonObject.storeJsonNestedObjectIntoNestedList(object);
        assertEquals(11, implementation.largestValue(nestedList.getNestedList()));
        assertNotEquals(23, implementation.largestValue(nestedList.getNestedList()));
    }

    /**
     * test for findValueTest method
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test
    public void searchTest() throws IOException, ParseException {
        JSONObject object = jsonObject.createJsonObject();
        NestedLinkedList nestedList = jsonObject.storeJsonNestedObjectIntoNestedList(object);
        System.out.println(nestedList.getNestedList().toString());
        List<Integer> expected = new ArrayList<>(Arrays.asList(6, 3, 0));
        List<Integer> actual = implementation.search(nestedList.getNestedList(), 6);
        assertEquals(expected.toString(), actual.toString());
        expected = new ArrayList<>(Arrays.asList(2));
        actual = implementation.search(nestedList.getNestedList(), 4);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test(expected = AssertionError.class)
    public void throwsAssertionErrorTest() {
        implementation.sum(new ArrayList<>());
        implementation.search(new ArrayList<>(Arrays.asList(1, 2)), 4);
        implementation.largestValue(new ArrayList<>());
    }
}
