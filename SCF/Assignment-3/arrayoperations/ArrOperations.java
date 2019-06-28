package arrayoperations;

/**
 * This class contains various operations on array
 *
 * @author Jai Kumar Garg
 */
class ArrOperations {

    /**
     * This method finds split point in the array so that the sum of the numbers
     * on one side is equal to the sum of the numbers on the other side.
     *
     * @param array contains all the elements of an array requires array length
     *              must be greater than 0
     * @return Return the index if there is a place to split the input array so
     * that the sum of the numbers on one side is equal to the sum of
     * the numbers on the other side else return -1
     */
    static int splitArray(int[] array) {
        if (array.length <= 0) {
            throw new AssertionError("Array is Empty");
        }
        int sumOfArray = 0;
        for (int i : array) {
            sumOfArray += i;
        }
        if (sumOfArray % 2 == 1) {
            return -1;
        }
        int firstHalfSum = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            firstHalfSum += array[i];
            sumOfArray -= array[i];
            if (sumOfArray == firstHalfSum) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method returns number of clumps in an array. Clumps: Clump in an
     * array is a series of 2 or more adjacent elements of the same value.
     *
     * @param array contains all the elements of an array requires array length
     *              must be greater than 0
     * @return the number of clumps in array
     */
    static int clumpsInArray(int[] array) {
        if (array.length <= 0) {
            throw new AssertionError("Array is Empty");
        }
        int count = 0;
        boolean match = false;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1] && !match) {
                match = true;
                count++;
            } else if (array[i] != array[i + 1]) {
                match = false;
            }
        }
        return count;
    }

    /**
     * This method Return an array that contains exactly the same numbers as the
     * input array, but rearranged so that every X is immediately followed by a
     * Y.
     *
     * @param array contains all the elements of an array requires array length
     *              must be greater than 0
     * @param x     is {@code Integer} value
     * @param y     is {@code Integer} value
     * @return the fixed array according to the value of x & y.
     */
    static int[] fixXY(int[] array, int x, int y) {
        if (array.length <= 0) {
            throw new AssertionError("Array is empty");
        }
        if (array[array.length - 1] == x) {
            throw new AssertionError("X is on last index of array");
        }
        int[] arr = array.clone();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == x && arr[i + 1] != y) {
                for (int j = 0; j < arr.length; j++) {
                    if (j == 0 && arr[j] == y) {
                        arr[j] = arr[i + 1];
                        arr[i + 1] = y;
                        break;
                    } else if (arr[j] == y && arr[j - 1] != x) {
                        arr[j] = arr[i + 1];
                        arr[i + 1] = y;
                        break;
                    }
                }
            }
        }
        return arr;
    }

    /**
     * This method returns mirror section in an array which is a group of
     * contiguous elements such that somewhere in the array, the same group
     * appears in reverse order.
     *
     * @param inputArray contains all the elements of an array requires array length
     *                   must be greater than 0
     * @return the length of maximum mirror
     */
    static int maxMirror(int[] inputArray) {
        if (inputArray.length <= 0) {
            throw new AssertionError("Array is Empty");
        }
        int mirrorLength = 0;
        int[][] longestMirror = new int[inputArray.length + 1][inputArray.length + 1];
        for (int i = 0; i <= inputArray.length; i++) {
            for (int j = 0; j <= inputArray.length; j++) {
                if (i == 0 || j == 0) {
                    longestMirror[i][j] = 0;
                } else if (inputArray[i - 1] == inputArray[inputArray.length - j]) {
                    longestMirror[i][j] = longestMirror[i - 1][j - 1] + 1;
                    mirrorLength = Math.max(mirrorLength, longestMirror[i][j]);
                } else {
                    longestMirror[i][j] = 0;
                }
            }
        }
        return mirrorLength;
    }
}
