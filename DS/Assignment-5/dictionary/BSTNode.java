package dictionary;

public class BSTNode<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private BSTNode<K, V> left, right;

    /**
     * Class constructor
     *
     * @param key   to store K
     * @param value to store V
     */
    public BSTNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public BSTNode<K, V> getLeft() {
        return left;
    }

    public BSTNode<K, V> getRight() {
        return right;
    }

    public void setLeft(BSTNode<K, V> left) {
        this.left = left;
    }

    public void setRight(BSTNode<K, V> right) {
        this.right = right;
    }

}
