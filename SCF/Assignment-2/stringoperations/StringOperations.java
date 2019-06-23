package stringoperations;

/**
 * This class contains various methods on String to perform operations on string
 * 1. Equality
 * 2. Reverse
 * 3. Change Case
 * 4. Find Largest Word
 *
 * @author Jai Kumar Garg
 */

public class StringOperations {
    /**
     * This method checks the equality of two string
     *
     * @param firstString   is object of first string require string is not null
     * @param anotherString is object of another string require string is not null
     * @return 1 if both strings are equal else 0
     */
    public int isEquals(String firstString, String anotherString) {
        if (firstString.length() != anotherString.length()) {
            return 0;
        } else {
            int i = 0;
            int length = firstString.length();
            while (length-- != 0) {
                if (firstString.charAt(i) != anotherString.charAt(i)) {
                    return 0;
                }
                i++;
            }
            return 1;
        }
    }

    /**
     * This reverse the provided string object's content
     *
     * @param string is object of string to be reverse requires string is not null
     * @return reverseString
     */
    public String reverse(String string) {
        String reverseString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reverseString += string.charAt(i);
        }
        return reverseString;
    }

    /**
     * This method replace lowercase characters of string with uppercase and vice-versa
     *
     * @param string is object of string to change case requires string is not null
     * @return changedString
     */
    public String changeCase(String string) {
        String changedString = "";
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= 65 && string.charAt(i) <= 90) {
                changedString += (char) ((int) string.charAt(i) + 32);
            } else if (string.charAt(i) >= 97 && string.charAt(i) <= 122) {
                changedString += (char) ((int) string.charAt(i) - 32);
            } else {
                changedString += string.charAt(i);
            }
        }
        return changedString;
    }

    /**
     * This method finds the largest word of a string.
     * If two words are of same length then it will return last word.
     *
     * @param string is string object requires string is not null
     * @return largest word from the string object
     */
    public String largestWord(String string) {

        String largestWord = "";
        String[] stringArray = string.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() >= largestWord.length()) {
                largestWord = stringArray[i];
            }
        }
        return largestWord;
    }
}