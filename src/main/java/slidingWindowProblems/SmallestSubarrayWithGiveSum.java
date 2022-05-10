package slidingWindowProblems;

public class SmallestSubarrayWithGiveSum {

    public static void main(String[] args) {

        System.out.println(smallestSubarrayWithGiveSum(new int[]{4, 2, 2, 7, 8, 1, 2, 8, 1, 0}, 8));
    }

    public static int smallestSubarray(int targetSum, int[] arr) {
        int minWindowSize = Integer.MAX_VALUE;
        int currentWindowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentWindowSum += arr[windowEnd];

            while (currentWindowSum >= targetSum) {
                minWindowSize = Math.min(minWindowSize, windowEnd - windowStart + 1);
                currentWindowSum -= arr[windowStart++];
            }
        }
        return minWindowSize;
    }

    public static int smallestSubarrayWithGiveSum(int[] arr, int sum) {
        int subarrayLength = Integer.MAX_VALUE;

        int a_pointer = 0;
        int b_pointer = 0;

        int currentSum = 0;

        while (b_pointer < arr.length) {
            if (currentSum < sum) {
                currentSum += arr[b_pointer++];
            } else {
                subarrayLength = Math.min(subarrayLength, b_pointer - a_pointer);
                currentSum -= arr[a_pointer++];
            }
        }
        return subarrayLength;

    }


}
