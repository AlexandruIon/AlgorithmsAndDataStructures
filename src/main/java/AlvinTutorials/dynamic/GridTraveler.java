package AlvinTutorials.dynamic;

import java.util.Map;

/**
 * treveler on a 2D grid.
 * begin in top-left corner and your goal is to travel to the bottom right corner
 * you may only move down or right
 * <p>
 * in how many ways you can travel to the goal of a grid of dimensions m*n
 */
public class GridTraveler {

    public static void main(String[] args) {

    }

    /**
     * complexity
     * height = m + n
     * => O(2 ^ (m+n)) time
     * => o(m+n) space
     *
     * memoization => m * n combinations
     *
     * O(m*n) time
     * O(n+m) space
     *
     * @param m
     * @param n
     * @param memo
     * @return
     */
    public static int travel(int m, int n, Map<String, Integer> memo) {
        String key = m + "," + n;
        if (m == 1 && n == 1) return 1;
        if (m == 0 || n == 0) return 0;
        int result = travel(m - 1, n, memo) + travel(m, n - 1, memo);
        memo.put(key, result);
        return result;

    }

}
