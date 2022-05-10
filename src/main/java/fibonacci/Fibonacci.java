package fibonacci;

public class Fibonacci {

//    https://r-knott.surrey.ac.uk/Fibonacci/fibpuzzles.html
    public static void main(String[] args) {
        assert (fibonacci(1) == 1);
        assert (fibonacci(5) == 5);
        assert (fibonacci(6) == 8);
        assert (fibonacci(20) == 6765);
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


}
