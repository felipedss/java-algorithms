package algorithms.binarysearch;

/**
 * binary search (on sorted array of integers)
 */
public class BinarySearch {

    private BinarySearch() {
    }

    public static int binarySearch(int key, int[] array, int min, int max) {

        if (max < min) {
            return -1;
        }

        int midPoint = min + ((max - min) / 2);

        if (array[midPoint] == key) {
            return midPoint;
        }

        if (array[midPoint] < key) {
            return binarySearch(key, array, midPoint + 1, max);
        }
        return binarySearch(key, array, min, midPoint - 1);
    }

}
