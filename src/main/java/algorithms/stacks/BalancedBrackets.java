package algorithms.stacks;

/**
 * Hackerrank challenge https://www.hackerrank.com/challenges/balanced-brackets/problem
 *
 */
public class BalancedBrackets {

    private BalancedBrackets() {
    }

    public static String isBalanced(String value) {
        char[] stack = new char[value.length()];
        int size = 0;
        for (int index = 0; index < value.length(); index++) {
            char item = value.charAt(index);
            if (item == '(' || item == '{' || item == '[') {
                stack[size] = item;
                size++;
                continue;
            }
            if ( size == 0
                    || (item == ')' && stack[size - 1] != '(')
                    || (item == '}' && stack[size - 1] != '{')
                    || (item == ']' && stack[size - 1] != '[')) {
                return "NO";
            }
            size--;
        }
        return size > 0 ? "NO" : "YES";
    }

}
