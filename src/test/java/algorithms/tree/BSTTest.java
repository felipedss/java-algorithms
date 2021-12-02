package algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

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
        assertTrue(bst.isEmpty());
    }

    @Test
    void testFindRightSide() {
        assertNotNull(bst.find(20));
    }

    @Test
    void testFindLeftSide() {
        assertNotNull(bst.find(8));
    }

    @Test
    void testExists() {
        assertTrue(bst.exists(20));
    }

    @Test
    void testMin() {
        assertEquals(8, bst.min());
    }

    @Test
    void testMax() {
        assertEquals(25, bst.max());
    }

    @Test
    void testMinWithEmptyTree() {
        BST bst = new BST();
        assertThrows(NoSuchElementException.class, bst::min);
    }

    @Test
    void testMaxWithEmptyTree() {
        BST bst = new BST();
        assertThrows(NoSuchElementException.class, bst::max);
    }

    @Test
    void testHeightWithEmptyTree() {
        BST bst = new BST();
        assertEquals(0, bst.height());
    }

    @Test
    void testHeight() {
        assertEquals(3, bst.height());
    }

    @Test
    void testIsBinarySearchTree() {
        BST bst = new BST();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(1);
        bst.add(6);
        assertTrue(bst.isBinarySearchTree());
    }

    @Test
    void testEmptyIsBinarySearchTree() {
        BST bst = new BST();
        assertTrue(bst.isBinarySearchTree());
    }
}
