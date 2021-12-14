package algorithms.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    void test() {
        int[] array = {10, 6, 5, 4, 2, 3, 7, 8, 9, 1};
        int[] ordered = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        MergeSort.mergeSort(array);
        Assertions.assertArrayEquals(ordered, array);
    }
}
