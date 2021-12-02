package algorithms.tree;

import static algorithms.tree.BinarySearchTreeDFS.inOrder;
import static algorithms.tree.BinarySearchTreeDFS.postOrder;
import static algorithms.tree.BinarySearchTreeDFS.preOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinarySearchTreeDFSTest {

    private static final BST bst = new BST();
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setup() {
        bst.add(15);
        bst.add(20);
        bst.add(10);
        bst.add(25);
        bst.add(17);
        bst.add(8);
        bst.add(12);
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testPreOrder() {
        preOrder(bst.root);
        assertEquals("15\n" +
                "10\n" +
                "8\n" +
                "12\n" +
                "20\n" +
                "17\n" +
                "25\n", outContent.toString());
    }

    @Test
    void testInOrder() {
        inOrder(bst.root);
        assertEquals("8\n" +
                "10\n" +
                "12\n" +
                "15\n" +
                "17\n" +
                "20\n" +
                "25\n", outContent.toString());
    }

    @Test
    void testPostOrder() {
        postOrder(bst.root);
        assertEquals("8\n" +
                "12\n" +
                "10\n" +
                "17\n" +
                "25\n" +
                "20\n" +
                "15\n", outContent.toString());
    }

}
