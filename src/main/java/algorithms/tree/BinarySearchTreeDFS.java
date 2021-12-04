package algorithms.tree;

/**
 * DFS (depth-first-search)
 * Space complexity O(h)
 * Time complexity O(n)
 */
public class BinarySearchTreeDFS {

    private BinarySearchTreeDFS() {
    }

    /**
     * <root><left><right>
     */
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * <left><root><right>
     */
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    /**
     * <left><right><root>
     */
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

}
