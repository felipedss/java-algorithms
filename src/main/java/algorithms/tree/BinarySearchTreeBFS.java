package algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS (breadth-first search) Using queue
 */
public class BinarySearchTreeBFS {

    private BinarySearchTreeBFS() {
        
    }

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.element();
            System.out.println(current.data);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
            queue.remove();
        }
    }

}
