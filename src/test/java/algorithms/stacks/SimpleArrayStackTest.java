package algorithms.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class SimpleArrayStackTest {

    private static final int CAPACITY = 10;

    @Test
    void testEmpty() {
        SimpleArrayStack simpleArrayStack = new SimpleArrayStack(CAPACITY);
        assertTrue(simpleArrayStack.isEmpty());
    }

    @Test
    void testTop() {
        SimpleArrayStack simpleArrayStack = new SimpleArrayStack(CAPACITY);
        simpleArrayStack.push(10);
        simpleArrayStack.push(20);
        simpleArrayStack.push(30);
        assertEquals(30 , simpleArrayStack.top());
    }

    @Test
    void testPop() {
        SimpleArrayStack simpleArrayStack = new SimpleArrayStack(CAPACITY);
        simpleArrayStack.push(10);
        simpleArrayStack.push(20);
        simpleArrayStack.push(30);
        assertEquals(30 , simpleArrayStack.pop());
        assertEquals(20 , simpleArrayStack.top());
    }

    @Test
    void testTopWithEmptyStack() {
        SimpleArrayStack simpleArrayStack = new SimpleArrayStack(CAPACITY);
        assertThrows(NoSuchElementException.class, simpleArrayStack::top);
    }

    @Test
    void testPopWithEmptyStack() {
        SimpleArrayStack simpleArrayStack = new SimpleArrayStack(CAPACITY);
        assertThrows(NoSuchElementException.class, simpleArrayStack::pop);
    }

}
