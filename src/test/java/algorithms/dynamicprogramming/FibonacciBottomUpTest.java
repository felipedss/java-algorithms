package algorithms.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import algorithms.dynamicprograming.FibonacciBottomUp;
import org.junit.jupiter.api.Test;

class FibonacciBottomUpTest {

    @Test
    void test() {
        FibonacciBottomUp fibonacciBottomUp = new FibonacciBottomUp();
        assertEquals(fibonacciBottomUp.fib(6), 8);
        assertEquals(fibonacciBottomUp.fib(5), 5);
        assertEquals(fibonacciBottomUp.fib(1), 1);
        assertEquals(fibonacciBottomUp.fib(2), 1);
    }

}
