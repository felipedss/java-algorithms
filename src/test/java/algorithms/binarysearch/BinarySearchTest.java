package algorithms.binarysearch;

import static algorithms.binarysearch.BinarySearch.binarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    void test() {
        int[] array = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
                41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        assertEquals(20, binarySearch(73, array, 0, 24));
    }

    @Test
    void testAtTheMidle() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(4, binarySearch(5, array, 0, 9));
    }

    @Test
    void testKeyNotExists() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(-1, binarySearch(25, array, 0, 9));
    }

}
