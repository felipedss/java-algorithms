package algorithms.tree;

/**
 * DFS (depth-first-search)
 */
public class BinarySearchTreeDFS {

    private BinarySearchTreeDFS() {
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

}
