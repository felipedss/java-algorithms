package algorithms.hashtable;

import java.util.HashMap;
import java.util.List;

/**
 * Hackerrank challenge
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 */
public class IceCreamParlor {

    private IceCreamParlor() {

    }

    public static String whatFlavours(List<Integer> cost, int money) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int index = 0; index < cost.size(); index++) {
            hash.put(cost.get(index), index + 1);
        }

        for (int index = 0; index < cost.size(); index++) {
            Integer key = cost.get(index);
            int other = money - key;
            Integer result = hash.get(other);
            if (result != null && index + 1 != result) {
                return (index + 1) + " " + hash.get(other);
            }
        }
        return null;
    }

}
