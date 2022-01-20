package algorithms.dynamicprograming;

/**
 * FibonacciTopDown
 * <p>
 * Is usually is easier to read
 */
public class FibonacciTopDown {

    public int fib(int number) {
        int[] memo = new int[number];
        return fib(number, memo);
    }

    private int fib(int number, int[] memo) {
        if (number == 0) {
            return number;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        if (memo[number - 1] == 0) {
            memo[number - 1] = fib(number - 1) + fib(number - 2);
        }
        return memo[number - 1];
    }


}
