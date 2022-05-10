package AlvinTutorials.dynamic;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static void main(String[] args) {
        System.out.println(canSum(7, new int[]{2, 3}, new HashMap<>())); //true
        System.out.println(canSum(7, new int[]{5, 3, 4, 7}, new HashMap<>())); //true
        System.out.println(canSum(7, new int[]{2, 4}, new HashMap<>())); //false
        System.out.println(canSum(8, new int[]{2, 3, 5}, new HashMap<>())); //true
        System.out.println(canSum(300, new int[]{7, 14}, new HashMap<>())); //false
    }


    /**
     * the function returns a boolean indicating whether or not
     * it is possile to generate the targetSum using numbers from the array
     * <p>
     * may use an element of the array as many times as needed
     * <p>
     * may assume that all input numbers are nonneative
     *
     * complexity = height of the tree and branching factor
     *
     *  m = target sum
     *  n = array length
     *
     * longest path from root to leaf doing -1 => the distance from root to a leaf is m because you have to substract 1 m times =>
     * height(depth) of the tree is m
     *
     * maximum branch factor is n (lenght of the array) (for an array with 3 elements the branching factor is 3 because we have 3 choices)
     *
     * => complexity
     * time = O(n^m)
     * space = O(m)
     *
     * => complexity memoized
     * time = O(m*n)
     * space = o(m)
     */
    private static boolean canSum(int targetSum, int[] numbers, Map<Integer, Boolean> memo) {

        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return true;
        if (targetSum < 0) return false;

        for (int number : numbers) {
            if (canSum(targetSum - number, numbers, memo)) {
                memo.put(targetSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }

}
