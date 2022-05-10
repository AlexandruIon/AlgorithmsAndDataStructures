package AlvinTutorials.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {

    public static void main(String[] args) {
        System.out.println(howSum(7, new int[]{2, 3}, new HashMap<>())); // [3,2,2]
        System.out.println(howSum(7, new int[]{5, 3, 4, 7}, new HashMap<>())); // [4,3]
        System.out.println(howSum(7, new int[]{2, 4}, new HashMap<>())); // null
        System.out.println(howSum(8, new int[]{2, 3, 5}, new HashMap<>())); // [2,2,2,2]
        System.out.println(howSum(300, new int[]{7, 14}, new HashMap<>())); // null
    }


    /**
     * return an array containing any combination of elements that add up to exactly
     * the targetSum. If there is no combination that adds up to the targetSum return null.
     * <p>
     * if there are multiple combinations possible, you may return any single one.
     *
     *brute force
     * time = O(n^m)
     * space = O(m)
     *
     * memoization
     * O(nm^2) time
     * O(m^2) space
     */

    static List<Integer> howSum(int targetSum, int[] numbers, Map<Integer, List<Integer>> memo) {
        if (memo.containsKey(targetSum)) return memo.get(targetSum);
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;

        for (int number : numbers) {
            List<Integer> reminderResult = howSum(targetSum - number, numbers, memo);
            if (reminderResult != null) {
                reminderResult.add(number);
                memo.put(targetSum, reminderResult);
                return reminderResult;
            }
        }
        memo.put(targetSum, null);
        return null;
    }

}
