package problems;

public class MaximumSubarray {

    public static void main(String[] args) {
        assert (maxSubArray(new int[]{1}) == 1);
        assert (maxSubArray(new int[]{-1}) == -1);
        assert (maxSubArray(new int[]{5, 4, -1, 7, 8}) == 23);
        assert (maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        assert (maxSubArray(new int[]{-1, -2}) == -1);

        assert (maxSubArrayCubic(new int[]{1}) == 1);
        assert (maxSubArrayCubic(new int[]{-1}) == -1);
        assert (maxSubArrayCubic(new int[]{5, 4, -1, 7, 8}) == 23);
        assert (maxSubArrayCubic(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        assert (maxSubArrayCubic(new int[]{-1, -2}) == -1);

        assert (maxSubArrayQuadratic(new int[]{1}) == 1);
        assert (maxSubArrayQuadratic(new int[]{-1}) == -1);
        assert (maxSubArrayQuadratic(new int[]{5, 4, -1, 7, 8}) == 23);
        assert (maxSubArrayQuadratic(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        assert (maxSubArrayQuadratic(new int[]{-1, -2}) == -1);

        assert (maxSubArrayLinear(new int[]{1}) == 1);
        assert (maxSubArrayLinear(new int[]{-1}) == -1);
        assert (maxSubArrayLinear(new int[]{5, 4, -1, 7, 8}) == 23);
        assert (maxSubArrayLinear(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6);
        assert (maxSubArrayLinear(new int[]{-1, -2}) == -1);
    }

    public static int maxSubArrayLinear(int[] nums) {
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            best = Math.max(best, sum);
        }
        return best;
    }

    public static int maxSubArrayQuadratic(int[] nums) {
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                best = Math.max(best, sum);
            }
        }
        return best;
    }

    public static int maxSubArray(int[] nums) {
        int currentSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum = nums[i];
            if (currentSum > maxSum) maxSum = currentSum;
            for (int j = i + 1; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum > maxSum) maxSum = currentSum;
            }
        }
        return maxSum;
    }

    // go through all possible arrays
    //The variables a and b fix the first and last index of the subarray, and the
    //sum of values is calculated to the variable sum. The variable best contains the
    //maximum sum found during the search.
    public static int maxSubArrayCubic(int[] nums) {
        int best = Integer.MIN_VALUE;
        for (int a = 0; a < nums.length; a++) {
            for (int b = a; b < nums.length; b++) {
                int sum = 0;
                for (int k = a; k <= b; k++) {
                    sum += nums[k];
                }
                best = Math.max(best, sum);
            }
        }
        return best;
    }

}
