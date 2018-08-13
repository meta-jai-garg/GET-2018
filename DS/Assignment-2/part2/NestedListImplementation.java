package part2;

import java.util.ArrayList;
import java.util.List;

public class NestedListImplementation implements NestedList {
    @SuppressWarnings("unchecked")
    public int sum(List<Object> nestedList) {
        if (nestedList.size() == 0) {
            throw new AssertionError("List is empty");
        }
        int sum = 0;

        for (Object nested : nestedList) {
            //if object is an Integer ,add directly to sum
            if (nested instanceof Integer) {
                sum = sum + (int) nested;
            }
            //if object is also a list ,it recursively calls sum method
            else if (nested instanceof List) {
                sum = sum + sum((List<Object>) nested);
            }
        }
        return sum;
    }

    public int largestValue(List<Object> nestedList) {
        return largestValue(nestedList, 0);
    }

    /**
     * If list element is an Integer than it checks for max value
     * else recursively find maximum element
     *
     * @param nestedList first level of nested list
     * @param max
     * @return maximum value integer from nested List
     */
    @SuppressWarnings("unchecked")
    private int largestValue(List<Object> nestedList, int max) {
        if (nestedList.size() == 0) {
            throw new AssertionError("List is empty");
        }
        int maxValue = max;
        for (Object nested : nestedList) {
            //if object is an Integer ,compare directly with max
            if (nested instanceof Integer) {
                if (maxValue < (int) nested) {
                    maxValue = (int) nested;
                }
            }
            //if object is a list it recursively calls largestValue method
            else if (nested instanceof List) {
                maxValue = largestValue(((List<Object>) nested), maxValue);
            }
        }
        return maxValue;
    }

    /**
     * recursively finds element in nested list
     *
     * @param nestedList first level of nested list
     * @param value      that is to be found
     * @return list of integer such that first value of list shows index in first level list
     * second value shows index in second level so on.
     */
    public List<Integer> search(List<Object> nestedList, int value) {
        if (nestedList.size() == 0) {
            throw new AssertionError("List is empty");
        }
        List<Integer> foundIndex = new ArrayList<Integer>();
        int index = 0;
        for (Object nested : nestedList) {
            //object is an integer it directly checks value
            if (nested instanceof Integer) {
                if (value == (int) nested) {
                    foundIndex.add(index);
                    return foundIndex;
                }
            }
            //object is a list it recursively call findValue method
            else if (nested instanceof List) {
                foundIndex.add(index);
                List<Integer> indexList = search((List<Object>) nested, value);
                //if value is found in nested list then it will return a list of index
                if (indexList.size() > 0) {
                    for (Integer indexfromList : indexList) {
                        foundIndex.add(indexfromList);
                    }
                    return foundIndex;
                }
                //value was not found in list at current index, so remove index from found index
                else {
                    foundIndex.remove(foundIndex.size() - 1);
                }
            }
            index++;
        }
        return foundIndex;
    }
}