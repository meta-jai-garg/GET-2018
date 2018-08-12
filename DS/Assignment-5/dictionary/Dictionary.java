package dictionary;

import java.util.List;

public interface Dictionary<K extends Comparable<K>, V> {
    /**
     * method to add key and value to dictionary
     *
     * @param key   is an object of K type
     * @param value is an object of V
     */
    void add(K key, V value);

    /**
     * Method to delete a value
     *
     * @param key is an object of K
     */
    void delete(K key);

    /**
     * Method to get particular value
     *
     * @param key is an object of K
     * @return the value V
     */
    V get(K key);

    /**
     * Method to get Sorted list of key value pair
     *
     * @return sorted list of key value pair
     */
    List<BSTNode<K, V>> getSortedList();

    /**
     * Method to get sorted list in range of given keys inclusive
     *
     * @param key1
     * @param key2
     * @return sorted list of key value pair in specified range inclusive
     */
    List<BSTNode<K, V>> getSortedList(K key1, K key2);
}
