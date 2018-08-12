package part2;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    /**
     * Get nested list from JSON file into JSON object
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException
     */
    public JSONObject createJsonObject() throws FileNotFoundException, IOException, ParseException {
        return (JSONObject) new JSONParser().parse(new FileReader("H:\\IdeaProjects\\DS#2\\src\\json_input.json"));
    }

    /**
     * store JSON object into nested list
     *
     * @param object
     * @return NestedList
     */
    public NestedLinkedList storeJsonNestedObjectIntoNestedList(JSONObject object) {
        NestedLinkedList nestedList = new NestedLinkedList();
        for (Object key : object.keySet()) {
            if (object.get(key) instanceof String) {
                nestedList.addValue(Integer.parseInt((String) object.get(key)));
            } else {
                nestedList.addList(storeJsonNestedObjectIntoNestedList((JSONObject) object.get(key)).getNestedList());
            }
        }
        return nestedList;
    }
}
