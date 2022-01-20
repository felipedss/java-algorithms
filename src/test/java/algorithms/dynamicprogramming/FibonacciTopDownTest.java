package algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.dynamicprograming.FibonacciTopDown;
import org.junit.jupiter.api.Test;

class FibonacciTopDownTest {

    @Test
    void test() {
        FibonacciTopDown fibonacciTopDown = new FibonacciTopDown();
        assertEquals(8, fibonacciTopDown.fib(6));
        assertEquals(5, fibonacciTopDown.fib(5));
        assertEquals(1, fibonacciTopDown.fib(1));
        assertEquals(1, fibonacciTopDown.fib(2));
    }

}
