import java.util.HashSet;
import java.util.Set;

public class Test2 {

    public static void main(String[] args) {
//        System.out.println(1 / 10);
//        System.out.println(2 / 10);
        System.out.println("19 is happpy " + isHappy(19));
        System.out.println("116 is happpy " + isHappy(116));
    }

    public static boolean isHappy(int n) {
        Set<Integer> as = new HashSet<>();
        while (n != 1  && !as.contains(n)) {
            as.add(n);
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n = n/ 10;
            }
            n = sum;
        }

        return n == 1;
    }

}
