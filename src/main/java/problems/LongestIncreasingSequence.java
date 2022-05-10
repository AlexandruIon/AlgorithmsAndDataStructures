package problems;

public class LongestIncreasingSequence {

    public int lengthOfLis(int[] arr, int n) {
        int lis[] = new int[n];
        int i, j, max = 0;

        // initialize lis values for all indexes
        for (i = 0; i < n; i++) {
            lis[i] = 1;
        }

        //compute optimized lis values in bottom up manner
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }

        for (i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }
        return max;

    }

}
