package algorithms.recursion;

/**
 * Fibonacci Sequence
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem?
 */
public class Fibonacci {


    public static void main(String[] args) {
        int n = 6;
        int[] memo = new int[n + 1];
        System.out.println(fib(n, memo));
    }

    private static int fib(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 0 || n == 1) {
            return n;
        }
        int result = fib(n - 1, memo) + fib(n - 2, memo);
        memo[n] = result;
        return result;
    }


}
