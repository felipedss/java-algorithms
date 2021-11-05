package algorithms.arrays;

import static algorithms.arrays.DynamicArray.ResizeType.DECREASE;
import static algorithms.arrays.DynamicArray.ResizeType.INCREASE;
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

    enum ResizeType {
        INCREASE,
        DECREASE
    }

    /**
     * Create a new Array e copy the elements
     */
    private void resize(int newCapacity, ResizeType resizeType) {
        int[] newArray = new int[newCapacity];
        if (INCREASE.equals(resizeType)) {
            arraycopy(this.array, 0, newArray, 0, this.array.length);
        } else {
            arraycopy(this.array, 0, newArray, 0, this.current);
        }
        this.array = newArray;
        this.capacity = newCapacity;
    }

    /**
     * Size of array
     */
    public int getSize() {
        return current;
    }

    /**
     * Determines if array isEmpty
     */
    public boolean isEmpty() {
        return current == 0;
    }

    /**
     * Get Capacity of array
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Returns item at given index, blows up if index out of bounds
     */
    public int at(int position) {
        if (position > current) {
            throw new IndexOutOfBoundsException(position);
        }
        return array[position];
    }

    /**
     * inserts item at last position
     */
    public void push(int val) {
        if (this.current == this.capacity) {
            this.capacity *= 2;
            resize(this.capacity, INCREASE);
        }
        array[current] = val;
        current++;
    }

    /**
     * inserts item at index, shifts that index's value and
     * trailing elements to the right
     */
    public void insert(int index, int val) {

        if (index > current) {
            throw new IndexOutOfBoundsException(index);
        }

        if (this.current == this.capacity) {
            this.capacity *= 2;
            resize(this.capacity, INCREASE);
        }

        System.arraycopy(array, index, array, index + 1, current - index);
        array[index] = val;
        current++;
    }

    /**
     * can use insert above at index 0
     */
    public void preprend(int val) {
        this.current++;
        if (this.current == this.capacity) {
            this.capacity *= 2;
            resize(this.capacity, INCREASE);
        }
        arraycopy(this.array, 0, this.array, 1, this.current);
        this.array[0] = val;
    }

    /**
     * remove from end, return value
     * <p>
     * when popping an item, if size is 1/4 of capacity, resize to half
     */
    public int pop() {
        if (current == this.capacity / 4) {
            this.capacity /= 4;
            resize(this.capacity, DECREASE);
        }
        return array[--current];
    }

    /**
     * delete item at index, shifting all trailing elements left
     */
    public void delete(int index) {
        if (index > current) {
            throw new IndexOutOfBoundsException(index);
        }
        arraycopy(this.array, index + 1, this.array, index, this.current - index);
        this.current--;
    }

    /**
     * looks for value and removes index holding it (even if in multiple places)
     */
    public void remove(int val) {
        for (int index = 0; index <= current; index++) {
            if (val == this.array[index]) {
                delete(index);
            }
        }
    }

    /**
     * looks for value and returns first index with that value, -1 if not found
     */
    public int find(int val) {
        for (int index = 0; index <= current; index++) {
            if (val == this.array[index]) {
                return index;
            }
        }
        return -1;
    }

}
