package algorithms.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/two-strings/problem
 */
public class TwoStrings {

    public static void main(String[] args) {
        String first = "be";
        String second = "cat";
        String s = hasTwoStrings(populateMap(second), first);
        System.out.println(s);
    }

    private static String hasTwoStrings(Map<Character, Integer> map, String string) {
        for (int i = 0; i < string.length(); i++) {
            Character c = string.charAt(i);
            if (map.get(c) != null) {
                return "YES";
            }
        }
        return "NO";
    }

    private static Map<Character, Integer> populateMap(String first) {
        Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < first.length(); index++) {
            map.put(first.charAt(index), index);
        }
        return map;
    }

}
