package algorithms.stacks;

import java.util.NoSuchElementException;

public class SimpleArrayStack {

    private final int[] array;
    private int size = 0;

    public SimpleArrayStack(int capacity) {
        this.array = new int[capacity];
    }

    /**
     * adds an item at the top
     *
     * @param element value
     */
    public void push(int element) {
        this.array[size] = element;
        size++;
    }

    /**
     * returns an item at the top
     *
     */
    public int top() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return this.array[size - 1];
    }

    /**
     * returns and remove an item at the top
     *
     */
    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int value = this.array[size - 1];
        size--;
        return value;
    }

    /**
     * bool returns true if empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
