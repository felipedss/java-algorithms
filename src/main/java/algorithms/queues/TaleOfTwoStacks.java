package algorithms.queues;

import static java.lang.System.arraycopy;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
 */
public class TaleOfTwoStacks {

    private final int capacity;
    private int[] array;
    private int size;

    public TaleOfTwoStacks(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public void enqueue(Integer nextInt) {
        array[size] = nextInt;
        size++;
    }

    public void dequeue() {
        if (size > 0) {
            int[] newArray = new int[capacity];
            arraycopy(array, 1, newArray, 0, array.length - 1);
            array = newArray;
            size--;
        }
    }

    public Integer peek() {
        return array[0];
    }

}
