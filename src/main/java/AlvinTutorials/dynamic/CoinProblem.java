package AlvinTutorials.dynamic;

public class CoinProblem {

    private static int [] coins = {1,3,4};
    private static boolean [] ready = new boolean[20];
    private static int [] value = new int[20];

    public static int solve(int x) {
        if (x < 0) {
            return 1000;
        }
        if (x == 0) {
            return 0;
        }
        int best = 1000;
        for (int coin : coins) {
            best = Math.min(best, solve(x - coin) + 1);
            System.out.println(best);
        }
        return best;
    }

    public static int solve2(int x) {
        if (x < 0) {
            return 1000;
        }
        if (x == 0) {
            return 0;
        }
        if(ready[x]) return value[x];
        int best = 1000;
        for (int coin : coins) {
            best = Math.min(best, solve2(x - coin) + 1);
            System.out.println(best);
        }
        value[x] = best;
        ready[x] = true;
        return best;
    }

    public static void main(String[] args) {


//        System.out.println(solve(10));
        System.out.println(solve2(10));

    }
}
