package com.felipedss.algorithms.arrays;

import static java.lang.System.arraycopy;

public class DynamicArray {

    private static final int DEFAULT_CAPACITY = 8;
    private int capacity;
    private int current;
    private int[] array;

    public DynamicArray() {
        this.capacity = DEFAULT_CAPACITY;
        this.current = 0;
        this.array = new int[DEFAULT_CAPACITY];
    }

    public int getSize() {
        return current;
    }

    public boolean isEmpty() {
        return current == 0;
    }

    public int at(int position) {

        if (position > current) {
            throw new IndexOutOfBoundsException(position);
        }

        return array[position];
    }

    public void push(int val) {
        if (current == capacity) {
            this.capacity = DEFAULT_CAPACITY * 2;
            final int[] newArray = new int[capacity];
            arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }
        array[current] = val;
        current++;
    }

    public void insert(int index, int val) {

        if (index > current) {
            throw new IndexOutOfBoundsException(index);
        }

        if (current == capacity) {
            this.capacity = DEFAULT_CAPACITY * 2;
            final int[] newArray = new int[capacity];
            arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }

        if (current - index >= 0) System.arraycopy(array, index, array, index + 1, current - index);

        array[index] = val;
        current++;
    }

}
