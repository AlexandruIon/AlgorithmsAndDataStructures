package backtracking;

public class FindAllSubsestsIterative {

    /*
     Set = [ a, b ,c]
     power_set_size = pow(2,3) = 8
     Run for binary counter = 000 to 111

     Value of counter             Subset
     000                           -> EmptySet
     001                           -> a
     010                           -> b
     011                           -> ab
     100                           -> c
     101                           -> ac
     110                           -> bc
     111                           -> abc
     */

    public static void printPowerSet(char[] set, int setSize) {
        long powerSetSize = (long) Math.pow(2, setSize);

        int counter, j;

        /*
        run from counter 00...0, to 11...1
         */

        for (counter = 0; counter < powerSetSize; counter++) {
            for (j = 0; j < setSize; j++) {
                /*
                check if jth bit in the counter is set
                if set then print jth element from set
                 */
                if ((counter & (1 << j)) > 0) {
                    System.out.println("Counter " + counter + " as binary " + Integer.toBinaryString(counter));
                    System.out.println("j " + j + " as binary " + Integer.toBinaryString(j));
                    int x = 1 << j;
                    System.out.println("j shifted " + x + " as binary " + Integer.toBinaryString(x));
                    System.out.println(set[j]);
                    System.out.println("------------");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[] set = {'a', 'b', 'c'};
        printPowerSet(set, 3);
    }

}
