package dictionary;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

public class BST<K extends Comparable<K>, V> implements Dictionary<K, V> {

    BSTNode<K, V> root;
    List<BSTNode<K, V>> list = new ArrayList<BSTNode<K, V>>();

    public BST() {
        this.root = null;
    }

    public BST(JSONObject jsonObject) {
        insertData(jsonObject);
    }

    private void insertData(JSONObject jsonObject) {
        for (Object key : jsonObject.keySet()) {
            add((K) key, (V) jsonObject.get(key));
        }
    }

    @Override
    public void add(K key, V value) {
        if (key == null || value == null) {
            throw new AssertionError("Can't add null");
        }
        if (root == null) {
            root = new BSTNode<>(key, value);
        } else {
            insertNode(root, key, value);
        }
    }

    /**
     * method to add node recursively is BST
     *
     * @param node
     * @param key
     * @param value
     */
    private void insertNode(BSTNode<K, V> node, K key, V value) {
        if (key.compareTo(node.getKey()) == 0) {
            throw new AssertionError("Key already exist!");
        } else if (key.compareTo(node.getKey()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new BSTNode<>(key, value));
            } else {
                insertNode(node.getRight(), key, value);
            }
        } else if (key.compareTo(node.getKey()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new BSTNode<>(key, value));
            } else {
                insertNode(node.getLeft(), key, value);
            }
        } else {
            throw new AssertionError("undesirable state");
        }
    }

    @Override
    public void delete(K key) {
        this.root = deleteNode(root, key);
    }

    /**
     * method to delete a node recursively
     *
     * @param node
     * @param key
     * @return
     */
    private BSTNode<K, V> deleteNode(BSTNode<K, V> node, K key) {
        if (key.compareTo(node.getKey()) == 0) {
            if ((node.getLeft() == null) && (node.getRight() == null)) {
                return null;
            } else if ((node.getLeft() == null) && (node.getRight() != null)) {
                return node.getRight();
            } else if ((node.getLeft() != null) && (node.getRight() == null)) {
                return node.getLeft();
            } else if ((node.getLeft() != null) && (node.getRight() != null)) {
                BSTNode<K, V> replaceNode = findMin(node.getRight());
                BSTNode<K, V> left = node.getLeft();
                replaceNode.setRight(deleteDoubleNode(node.getRight()));
                replaceNode.setLeft(left);
                return replaceNode;
            }
        } else if (key.compareTo(node.getKey()) < 0) {
            if (node.getLeft() != null) {
                node.setLeft(deleteNode(node.getLeft(), key));
                return node;
            }
        } else {
            if (node.getRight() != null) {
                node.setRight(deleteNode(node.getRight(), key));
                return node;
            }
        }
        return node;
    }

    /**
     * method to delete a node which is having two child
     *
     * @param node
     * @return
     */
    private BSTNode<K, V> deleteDoubleNode(BSTNode<K, V> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        } else {
            node.setLeft(deleteDoubleNode(node.getLeft()));
        }
        return node;
    }

    private BSTNode<K, V> findMin(BSTNode<K, V> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public V get(K key) {
        BSTNode<K, V> node;
        node = search(key);
        if (node == null) {
            throw new AssertionError("value not found");
        } else {
            return search(key).getValue();
        }
    }

    /**
     * method to search for given key recursively
     *
     * @param key
     * @return
     */
    private BSTNode<K, V> search(K key) {
        if (key == null) {
            throw new AssertionError("Key is null");
        }
        if (root == null) {
            throw new AssertionError("Dictionary is empty");
        }
        if (key.compareTo(root.getKey()) == 0) {
            return root;
        } else if (key.compareTo(root.getKey()) > 0) {
            return searchNode(root.getRight(), key);
        } else if (key.compareTo(root.getKey()) < 0) {
            return searchNode(root.getLeft(), key);
        } else {
            return null;
        }
    }

    private BSTNode<K, V> searchNode(BSTNode<K, V> node, K key) {
        if (node == null) {
            throw new AssertionError("Invalid");
        }
        if (key.compareTo(node.getKey()) == 0) {
            return node;
        } else if (key.compareTo(node.getKey()) > 0) {
            return searchNode(node.getRight(), key);
        } else if (key.compareTo(node.getKey()) < 0) {
            return searchNode(node.getLeft(), key);
        } else {
            return null;
        }
    }

    @Override
    public List<BSTNode<K, V>> getSortedList() {
        inOrder(root);
        return list;
    }

    /**
     * Inorder traversing of BST to get sorted list
     *
     * @param node
     */
    private void inOrder(BSTNode<K, V> node) {
        if (node != null) {
            inOrder(node.getLeft());
            list.add(new BSTNode<K, V>(node.getKey(), node.getValue()));
            inOrder(node.getRight());
        }
    }

    @Override
    public List<BSTNode<K, V>> getSortedList(K key1, K key2) {
        if (key1 == null || key2 == null) {
            throw new AssertionError("Invalid input!!!");
        }
        List<BSTNode<K, V>> tempList = getSortedList();
        List<BSTNode<K, V>> slicedList = new ArrayList<BSTNode<K, V>>();
        int i = 0;
        while (key1.compareTo(tempList.get(i).getKey()) <= 0
                && key2.compareTo(tempList.get(i).getKey()) >= 0) {
            slicedList.add(tempList.get(i));
            i++;
        }
        return slicedList;
    }
}