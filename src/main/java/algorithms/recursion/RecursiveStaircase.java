package algorithms.recursion;

/**
 *
 */
public class RecursiveStaircase {

    final static long _MOD = 1000000007;

    public static void main(String[] args) {

        System.out.println(countPathsMemoized(7));

    }

    public static long countPathsMemoized(int numberOfSteps) {
        long[] memo = new long[numberOfSteps + 1];
        long numberOfWays = 1;
        for(int i = 1; i < numberOfSteps; i++) {
            numberOfWays += countPathsMemoized(i, memo);
        }
        return numberOfWays % _MOD;
    }

    public static long countPathsMemoized(int numberOfSteps, long[] memo) {
        if(numberOfSteps < 3) {
            return (numberOfSteps > 0) ? numberOfSteps : 0;
        }
        if(memo[numberOfSteps] == 0) {
            memo[numberOfSteps] = (
                    countPathsMemoized(numberOfSteps - 1, memo)
                            + countPathsMemoized(numberOfSteps - 2, memo)
                            + countPathsMemoized(numberOfSteps - 3, memo)
            ) % _MOD;

        }
        return memo[numberOfSteps];
    }

}
