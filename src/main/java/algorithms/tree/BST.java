package algorithms.tree;

public class BST {

    private Node root;

    public boolean isEmpty() {
        return this.root == null;
    }

    static class Node {
        int data;
        Node left;
        Node rigth;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Add value into tree
     *
     * @param key value
     */
    public void add(int key) {
        this.root = insert(key, root);
    }

    private Node insert(int key, Node node) {
        if (node == null) {
            return new Node(key);
        }
        if (key > node.data) {
            node.rigth = insert(key, node.rigth);
        } else if (key < node.data) {
            node.left = insert(key, node.left);
        }
        return node;
    }

    /**
     * returns Node if given value exists in the tree
     *
     * @param key value
     * @return Node
     */
    public Node find(int key) {
        return find(key, root);
    }

    /**
     * returns true if given value exists in the tree
     *
     * @param key value
     * @return boolean
     */
    public boolean exists(int key) {
        return find(key, root) != null;
    }

    private Node find(int key, Node node) {
        if (node == null || node.data == key) {
            return node;
        }
        if (key > node.data) {
            return find(key, node.rigth);
        }
        return find(key, node.left);
    }


}
