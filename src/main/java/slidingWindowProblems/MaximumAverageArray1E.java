package slidingWindowProblems;

public class MaximumAverageArray1E {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(findMaxAverage(new int[]{5}, 1));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;

        double sum = 0;

        while (j < k && j < nums.length) {
            sum += nums[j++];
        }
        double res = sum;

        while (j < nums.length) {
            sum -= nums[i++];
            sum += nums[j++];
            res = Math.max(res, sum);
        }
        return res / k;
    }

}
