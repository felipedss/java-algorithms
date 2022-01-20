package algorithms.dynamicprograming;

public class FibonacciBottomUp {

    public int fib(int number) {
        int[] array = new int[number];

        if (number == 1 || number == 2) {
            return 1;
        }

        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < number; i++) {
            array[i] += array[i - 1] + array[i - 2];
        }
        return array[number - 1];
    }
}
