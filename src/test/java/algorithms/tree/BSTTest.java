package algorithms.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BSTTest {

    private static final BST bst = new BST();

    @BeforeAll
    public static void setup() {
        bst.add(15);
        bst.add(20);
        bst.add(10);
        bst.add(25);
        bst.add(17);
        bst.add(8);
        bst.add(12);
    }

    @Test
    void testEmpty() {
        BST bst = new BST();
        Assertions.assertTrue(bst.isEmpty());
    }

    @Test
    void testFindRightSide() {
        Assertions.assertNotNull(bst.find(20));
    }

    @Test
    void testFindLeftSide() {
        Assertions.assertNotNull(bst.find(8));
    }

    @Test
    void testExists() {
        Assertions.assertTrue(bst.exists(20));
    }
}
