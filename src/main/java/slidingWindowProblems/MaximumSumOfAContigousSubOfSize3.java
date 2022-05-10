package slidingWindowProblems;

public class MaximumSumOfAContigousSubOfSize3 {

    public static void main(String[] args) {

        System.out.println(size(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}));

    }

    public static int findMaxSumSubarray(int[]arr, int k){
        int maxValue = Integer.MIN_VALUE;
        int currentRunningSum = 0;

        for (int i = 0; i < arr.length; i++){
            currentRunningSum += arr[i];
            if(i>=k-1){
                maxValue = Math.max(maxValue, currentRunningSum);
                currentRunningSum -= arr[i-(k-1)];
            }
        }
        return  maxValue;
    }

    public static int size(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        int a_pointer = 0;
        int b_pointer = 0;

        while (b_pointer < 3 && b_pointer < arr.length) {
            currentSum += arr[b_pointer++];
        }
        while (b_pointer < arr.length) {
            currentSum += arr[b_pointer++];
            currentSum -= arr[a_pointer++];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }


}
