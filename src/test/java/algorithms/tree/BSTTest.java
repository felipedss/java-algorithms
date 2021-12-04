package algorithms.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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


    @ParameterizedTest
    @CsvSource({
            "15",
            "12",
            "5",
            "17"
    })
    void testDelete(int value) {
        BST bst = new BST();
        bst.add(12);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(17);
        bst.add(1);
        bst.add(9);
        assertNotNull(bst.delete(value));
    }

    @Test
    void testDeleteEmptyTree() {
        BST bst = new BST();
        assertNotNull(bst.delete(17));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 5",
            "12, 13",
            "7, 9"
    })
    void testSucessor(int value, int expected ) {
        BST bst = new BST();
        bst.add(12);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(17);
        bst.add(1);
        bst.add(9);
        Node successor = bst.getSuccessor(bst.root, value);
        Assertions.assertEquals(expected, successor.data);
    }

    @Test
    void testSucessor17() {
        BST bst = new BST();
        bst.add(12);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(17);
        bst.add(1);
        bst.add(9);
        Node successor = bst.getSuccessor(bst.root, 17);
        Assertions.assertNull(successor);
    }

    @Test
    void testSucessorEmptyTree() {
        BST bst = new BST();
        Assertions.assertNull(bst.getSuccessor(bst.root, 7));
    }
}
