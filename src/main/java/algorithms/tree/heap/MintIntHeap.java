package algorithms.tree.heap;

import java.util.Arrays;

/**
 * Heap / Priority Queue / Binary Heap
 */
public class MintIntHeap {

    private int capacity;
    private int size = 0;
    private int[] items;

    public MintIntHeap(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * returns the min item, without removing it
     *
     * @return int
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    /**
     * returns the min item, removing it
     *
     * @return int
     */
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapfyDown();
        return item;
    }

    /**
     * insert
     *
     * @param item item
     */
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapfyUp();
    }

    /**
     * Needed for insert
     */
    private void heapfyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * Needed for extract min
     */
    private void heapfyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
                index = smallerChildIndex;
            }
        }
    }

    /**
     * return number of elements stored
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * returns true if heap contains no elements
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size == 0;
    }

}
