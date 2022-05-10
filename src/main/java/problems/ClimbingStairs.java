package problems;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    public static void main(String[] args) {
        assert (climbStairs(1) == 1);
        assert (climbStairs(2) == 2);
        assert (climbStairs(3) == 3);
        assert (climbStairs(4) == 5);
        assert (climbStairs(5) == 8);

        assert (climbStairsWays(1) == 1);
        assert (climbStairsWays(2) == 2);
        assert (climbStairsWays(3) == 3);
        assert (climbStairsWays(4) == 5);
        assert (climbStairsWays(5) == 8);

        assert (climbStairs3Ways(1) == 1);
        assert (climbStairs3Ways(2) == 2);
        assert (climbStairs3Ways(3) == 4);
        assert (climbStairs3Ways(4) == 7);
        assert (climbStairs3Ways(5) == 13);
        assert (climbStairs3Ways(6) == 24);
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    public static int climbStairsWithMemorization(int n) {
        if (n <= 2) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result = climbStairsWithMemorization(n - 1) + climbStairsWithMemorization(n - 2);
        memo.put(n, result);
        return result;
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    //bottom up
    public static int climbStairsArray(int n) {
        if (n <= 2) return n;
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;

        for (int i = 3; i < steps.length; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    //ways(1) = fib(2) = 1
    //ways(2) = fib(3) = 2
    //ways(3) = fib(4) = 3
    public static int climbStairsWays(int n) {
        return fibonacci(n + 1);
    }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static int climbStairs3Ways(int n) {
        if (n == 0) return 1;

        if (n <= 2) return n;
        int result = climbStairs3Ways(n - 1) + climbStairs3Ways(n - 2) + climbStairs3Ways(n - 3);
        memo.put(n, result);
        return result;
    }

}
