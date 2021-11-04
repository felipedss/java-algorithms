package algorithms.arrays;

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

    public int getCapacity() {
        return capacity;
    }

    public int at(int position) {

        if (position > current) {
            throw new IndexOutOfBoundsException(position);
        }

        return array[position];
    }

    public void push(int val) {
        allocateArraySize();
        array[current] = val;
        current++;
    }

    public void insert(int index, int val) {

        if (index > current) {
            throw new IndexOutOfBoundsException(index);
        }

        allocateArraySize();

        if (current - index >= 0) System.arraycopy(array, index, array, index + 1, current - index);

        array[index] = val;
        current++;
    }

    public void preprend(int val) {
        allocateArraySize();
        this.current++;
        arraycopy(this.array, 0, this.array, 1, this.current);
        this.array[0] = val;
    }

    public int pop() {
        return array[--current];
    }

    public void delete(int index) {
        if (index > current) {
            throw new IndexOutOfBoundsException(index);
        }
        arraycopy(this.array, index + 1, this.array, index, this.current - index);
        this.current--;
    }

    public void remove(int val) {
        for (int i = 0; i <= current; i++) {
            if (val == this.array[i]) {
                delete(i);
            }
        }
    }

    public int find(int val) {
        for (int i = 0; i <= current; i++) {
            if (val == this.array[i]) {
                return i;
            }
        }
        return -1;
    }

    private void allocateArraySize() {
        if (this.current == this.capacity) {
            this.capacity *= 2;
            int[] newArray = new int[this.capacity];
            arraycopy(this.array, 0, newArray, 0, this.array.length);
            this.array = newArray;
        }
    }


}
