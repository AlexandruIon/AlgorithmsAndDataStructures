package AlvinTutorials;

public class RecursionProblems {

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 5, 7, -2})); //11
        System.out.println(sum2(new int[]{1, 5, 7, -2})); //11
        System.out.println(sum(new int[]{6, 3, 1})); //10
        System.out.println(sum2(new int[]{6, 3, 1})); //10
    }

    //O(N)
    static int sum(int[] arr) {
        return sum(arr, 0);
    }

    static int sum(int[] arr, int index) {
        if (index == arr.length) return 0;
        int sum = 0;
        sum += arr[index] + sum(arr, index + 1);
        return sum;
    }

    //O(n)
    static int sumBetter(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sum(arr, index + 1);
    }

    static int sum2(int[] arr) {
        return sum2(arr, arr.length - 1);
    }

    static int sum2(int[] arr, int index) {
        if (index < 0) return 0; // empty array
        int sum = 0;
        sum += arr[index] + sum2(arr, index - 1);
        return sum;

    }

    //time = O(n*n) = O(n^2) - n recursion * n arrayCopy
    //space = O(n)

//    static int sum3(int[] arr) {
//        if (arr.length == 0) return 0;
//        return arr[0] + sum3(Arrays.copyOf(arr, arr[1], arr.length));
//    }

    //time O(2^N)
    // space O(N)
    int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

}

