package part2;

import java.util.List;

public interface NestedList {
    int sum(List<Object> nestedList);

    int largestValue(List<Object> nestedList);

    List<Integer> search(List<Object> nestedList, int value);
}
