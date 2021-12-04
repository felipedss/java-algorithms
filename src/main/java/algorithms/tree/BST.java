package algorithms.tree;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

import java.util.NoSuchElementException;

public class BST {

    Node root;

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
            node.right = insert(key, node.right);
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
            return find(key, node.right);
        }
        return find(key, node.left);
    }

    private Node min(Node node) {
        if (node == null) {
            throw new NoSuchElementException("Tree is empty");
        }
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    private Node max(Node node) {
        if (node == null) {
            throw new NoSuchElementException("Tree is empty");
        }
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    /**
     * returns the minimum value stored in the tree
     *
     * @return int
     */
    public int min() {
        return min(root).data;
    }

    /**
     * returns the maximum value stored in the tree
     *
     * @return int
     */
    public int max() {
        return max(root).data;
    }

    /**
     * returns the height in nodes (single node's height is 1)
     *
     * @return int
     */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Determines if isEmpty
     */
    public boolean isEmpty() {
        return this.root == null;
    }

    /**
     * is_binary_search_tree
     *
     * @return boolean
     */
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, MIN_VALUE, MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        return root.data > minValue
                && root.data < maxValue
                && isBinarySearchTree(root.left, minValue, root.data)
                && isBinarySearchTree(root.right, root.data, maxValue);
    }

    public Node delete(int data) {
        root = deleteNode(root, data);
        return root;
    }

    public Node deleteNode(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = deleteNode(node.left, data);
        } else if (data > node.data) {
            node.right = deleteNode(node.right, data);
        } else {

            //CASE 1 : No child
            if (node.left == null && node.right == null) {
                return null;
            }

            //CASE 2 : One child
            else if (node.left == null) {
                node = node.right;
                return node;
            } else if (node.right == null) {
                node = node.left;
                return node;
            }

            //CASE 3
            else {
                Node min = min(node.right);
                node.data = min.data;
                node.right = deleteNode(node.right, min.data);
            }
        }
        return node;
    }

    /**
     * Function to find Inorder Sucessor in BST
     * Time complexity O(h)
     */
    public Node getSuccessor(Node node, int data) {

        //Search the node - O(h)
        Node current = find(data, node);

        if (current == null) {
            return null;
        }

        //case 1 - Node has right subtree
        if (current.right != null) {
            return min(current.right);
        }
        //case 2 - No right subtree
        else {
            Node successor = null;
            Node ancestor = node;
            while (ancestor != current) {
                if (current.data < ancestor.data) {
                    successor = ancestor;
                    ancestor = ancestor.left;
                } else {
                    ancestor = ancestor.right;
                }
            }
            return successor;
        }
    }


}
