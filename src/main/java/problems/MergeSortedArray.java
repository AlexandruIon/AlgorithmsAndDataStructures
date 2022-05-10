package problems;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {


        System.out.println(Arrays.toString(merge2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));

    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++)
            nums1[i + m] = nums2[i];
        Arrays.sort(nums1);
        return nums1;
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int tmp = 0;
        int j = 0;

        for (int i = 0; i < m + n; i++) {
            if (nums1[i] > nums2[j]) {
                tmp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = tmp;
            }
        }
        if (j < n) {
            while (j <= n) {
                nums1[m + n - j] = nums2[j];
                j++;

            }
        }
        return nums1;
    }

}
