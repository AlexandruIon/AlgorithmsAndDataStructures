package AlvinTutorials.dynamic;

import java.util.Map;

public class Fibonnaci {

    public static void main(String[] args) {

    }

    /**
     * fibonacci O(2^n)
     * fibonacci momoized O(n) time O(n) space
     *
     * @param n
     * @param memo
     * @return
     */
    private static int fibonnacci(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n < 2) return 1;
        int val = fibonnacci(n - 1, memo) + fibonnacci(n - 2, memo);
        memo.put(n, val);
        return val;


    }

}
