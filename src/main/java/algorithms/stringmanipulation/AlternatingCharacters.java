package algorithms.stringmanipulation;

/**
 * https://www.hackerrank.com/challenges/alternating-characters/problem
 */
public class AlternatingCharacters {

    public static void main(String[] args) {

        String value = "AABAAB";

        int requiredDeletions = getRequiredDeletions(value);
        System.out.println(requiredDeletions);
    }

    private static int getRequiredDeletions(String value) {
        if (value.length() == 0) {
            return 0;
        }
        char lastChar = value.charAt(0);
        int requiredChars = 0;
        for (int index = 1; index < value.length(); index++) {
            if (value.charAt(index) == lastChar) {
                requiredChars++;
            } else {
                lastChar = value.charAt(index);
            }
        }
        return requiredChars;
    }

}
