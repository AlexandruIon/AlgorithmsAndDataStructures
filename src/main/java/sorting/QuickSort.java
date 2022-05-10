package sorting;

import java.util.Arrays;

/**
 * The quicksort algorithm’s
 * desirable features are that it is in-place (uses only a small auxiliary stack) and that
 * it requires time proportional to N log N on the average to sort an array of length N.
 * None of the algorithms that we have so far considered combine these two properties.
 * <p>
 * Furthermore, quicksort has a shorter inner loop than most other sorting algorithms,
 * which means that it is fast in practice as well as in theory. Its primary drawback is that
 * it is fragile in the sense that some care is involved in the implementation to be sure to
 * avoid bad performance.
 * <p>
 * It works by partitioning an array into two subarrays, then sorting the subarrays independently.
 * <p>
 * Quicksort is complementary to mergesort: for mergesort, we break the array
 * into two subarrays to be sorted and then combine the ordered subarrays to make the
 * whole ordered array; for quicksort, we rearrange the array such that, when the two
 * subarrays are sorted, the whole array is ordered.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 2, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int lo, int hi) {

        if (lo >= hi) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1); // Sort left part a[lo .. j-1].
        sort(arr, j + 1, hi); // Sort right part a[j+1 .. hi].
    }

    /**
     * The crux of the method is the partitioning process, which rearranges the array to
     * make the following three conditions hold:
     * ■ The entry a[j] is in its fi nal place in the array, for some j.
     * ■ No entry in a[lo] through a[j-1] is greater than a[j].
     * ■ No entry in a[j+1] through a[hi] is less than a[j].
     * <p>
     * First, we arbitrarily choose a[lo] to be the partitioning
     * item—the one that will go into its final position. Next, we
     * scan from the left end of the array until we find an entry
     * greater than (or equal to) the partitioning item, and we scan
     * from the right end of the array until we find an entry less
     * than (or equal to) the partitioning item. The two items that
     * stopped the scans are out of place in the final partitioned array, so we exchange them.
     */
    public static int partition(int[] arr, int lo, int hi) {

        int i = lo, j = hi + 1;
        int v = arr[lo];

        while (true) {
            while (less(arr[++i], v)) if (i == hi) break;
            while (less(v, arr[--j])) if (j == lo) break;
            if (i >= j) break;
            swap(i, j, arr);
        }
        swap(lo, j, arr);
        return j;
    }

    public static boolean less(int a, int b) {
        return a < b;
    }

    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
