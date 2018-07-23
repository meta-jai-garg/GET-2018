package recursion;

public class Search {
    /**
     * This method finds a given element in array using linear search
     *
     * @param array   array of {@code Integer} elements
     * @param low     is {@code Integer} starting index of array
     * @param high    is {@code Integer} highest index of array
     * @param element is {@code Integer} the element to be search
     * @return the index of @param element if found else -1
     */
    static int linearSearch(int[] array, int low, int high, int element) {
        if (low > high) {
            return -1;
        } else if (array[low] == element) {
            return low;
        } else {
            return linearSearch(array, low + 1, high, element);
        }

    }

    /**
     * This method finds a given element in array using binary search
     *
     * @param array   array of {@code Integer} elements requires array be sorted
     * @param low     is {@code Integer} starting index of array
     * @param high    is {@code Integer} highest index of array
     * @param element is {@code Integer} the element to be search
     * @return the index of @param element if found else -1
     */
    static int binarySearch(int[] array, int low, int high, int element) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == element) {
                return mid;
            } else if (array[mid] > element) {
                return binarySearch(array, low, mid - 1, element);
            } else {
                return binarySearch(array, mid + 1, high, element);
            }
        }
        return -1;
    }
}
