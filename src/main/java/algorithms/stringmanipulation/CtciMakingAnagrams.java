package algorithms.stringmanipulation;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */
public class CtciMakingAnagrams {

    public static final int NUMBER_OF_LETTERS = 26;

    public static void main(String[] args) {

        final String a = "fcrxzwscanmligyxyvym";
        final String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        int numberNeeded = makeAnagram(a, b);
        System.out.println(numberNeeded);

    }

    private static int makeAnagram(String first, String second) {
        int[] firstArray = getCountChars(first);
        int[] secondArray = getCountChars(second);
        return getDifference(firstArray, secondArray);
    }

    private static int getDifference(int[] firstArray, int[] secondArray) {
        int difference = 0;
        for (int i = 0; i < NUMBER_OF_LETTERS; i++) {
            difference += Math.abs(firstArray[i] - secondArray[i]);
        }
        return difference;
    }

    private static int[] getCountChars(String first) {
        int[] array = new int[NUMBER_OF_LETTERS];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            int offset = 'a';
            int code = c - offset;
            array[code]++;
        }
        return array;
    }

}
