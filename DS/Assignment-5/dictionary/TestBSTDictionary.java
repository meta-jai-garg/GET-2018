package dictionary;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestBSTDictionary {
    @Test
    public void testAdd() throws ParseException, IOException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        // to check insertion of key and values
        assertEquals("two", dictionary.get("2"));
        assertEquals("five", dictionary.get("5"));
    }

    /**
     * Case when adding already exist key
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test(expected = AssertionError.class)
    public void testAddException() throws ParseException, IOException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.add("5", "five");
    }

    /**
     * Case when adding null key
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test(expected = AssertionError.class)
    public void testAddException2() throws ParseException, IOException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.add(null, "five");
    }


    /**
     * Case when adding null value
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test(expected = AssertionError.class)
    public void testAddException3() throws ParseException, IOException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.add("10", null);
    }

    /**
     * Case when both key and value are null
     *
     * @throws ParseException
     * @throws IOException
     */
    @Test(expected = AssertionError.class)
    public void testAddException4() throws ParseException, IOException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.add(null, null);
    }

    /**
     * deletion on key value pair
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test(expected = AssertionError.class)
    public void testDelete() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        assertEquals("four", dictionary.get("4"));
        dictionary.delete("4");
        //exception case because key already deleted
        dictionary.get("4");
    }

    /**
     * when key is present
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void testGet() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        assertEquals("four", dictionary.get("4"));
        assertEquals("eight", dictionary.get("8"));
    }

    /**
     * when key is not present
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test(expected = AssertionError.class)
    public void testGetException() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.get("10");
    }


    @Test
    public void testGetSortedDictionary() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));

        List<BSTNode<String, String>> actualSortedDictionary = dictionary.getSortedList();
        List<BSTNode<String, String>> expectedSortedDictionary = new ArrayList<>(
                Arrays.asList(new BSTNode<String, String>("2", "two"),
                        new BSTNode<String, String>("3", "three"),
                        new BSTNode<String, String>("4", "four"),
                        new BSTNode<String, String>("5", "five"),
                        new BSTNode<String, String>("6", "six"),
                        new BSTNode<String, String>("7", "seven"),
                        new BSTNode<String, String>("8", "eight")));

        for (int i = 0; i < actualSortedDictionary.size(); i++) {
            assertEquals(expectedSortedDictionary.get(i).getKey(), actualSortedDictionary.get(i).getKey());
            assertEquals(expectedSortedDictionary.get(i).getValue(), actualSortedDictionary.get(i).getValue());
        }
    }

    @Test
    public void testGetSortedDictionaryRange() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));

        List<BSTNode<String, String>> actualSortedDictionary = dictionary.getSortedList("3", "6");
        List<BSTNode<String, String>> expectedSortedDictionary = new ArrayList<>(
                Arrays.asList(new BSTNode<String, String>("3", "three"),
                        new BSTNode<String, String>("4", "four"),
                        new BSTNode<String, String>("5", "five"),
                        new BSTNode<String, String>("6", "six")));

        for (int i = 0; i < actualSortedDictionary.size(); i++) {
            assertEquals(expectedSortedDictionary.get(i).getKey(), actualSortedDictionary.get(i).getKey());
            assertEquals(expectedSortedDictionary.get(i).getValue(), actualSortedDictionary.get(i).getValue());
        }
    }

    /**
     * when both keys are null
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test(expected = AssertionError.class)
    public void getSortedDictionaryRangeException1() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.getSortedList(null, null);
    }

    /**
     * when first key is null
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test(expected = AssertionError.class)
    public void getSortedDictionaryRangeException2() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.getSortedList(null, "4");
    }

    /**
     * when second key is null
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test(expected = AssertionError.class)
    public void getSortedDictionaryRangeException3() throws IOException, ParseException {
        Dictionary<String, String> dictionary = new BST<>((JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#5\\src\\dictionary\\data.json")));
        dictionary.getSortedList("2", null);
    }
}