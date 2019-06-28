package recursion;

import org.junit.Assert;
import org.junit.Test;

public class SearchTest {
    @Test
    public void linearSearch() {
        Assert.assertEquals("Failure", 3, Search.linearSearch(new int[]{10, 7, 8, 9, 12, 13}, 0, 5, 9));
    }

    @Test
    public void binarySearch() {
        Assert.assertEquals("Failure", 3, Search.binarySearch(new int[]{5, 6, 7, 8, 9, 10}, 0, 5, 8));
    }
}
