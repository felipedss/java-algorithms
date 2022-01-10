package algorithms.recursion;

/**
 * Fibonacci Sequence
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem?
 */
public class Fibonacci {


    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    private static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
