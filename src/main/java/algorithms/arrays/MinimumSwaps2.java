package algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
public class MinimumSwaps2 {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 31, 1, 38, 29, 5, 44, 6, 12, 18, 39, 9, 48, 49, 13, 11, 7, 27, 14, 33, 50, 21, 46, 23, 15, 26, 8, 47, 40, 3, 32, 22, 34, 42, 16, 41, 24, 10, 4, 28, 36, 30, 37, 35, 20, 17, 45, 43, 25, 19};

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int value = arr[i];
                int toSwap = map.get(i + 1);
                arr[i] = arr[toSwap];
                arr[toSwap] = value;
                map.put(arr[i], i);
                map.put(value, toSwap);
                count++;
            }
        }
        System.out.println("Count: " + count);
    }


}
