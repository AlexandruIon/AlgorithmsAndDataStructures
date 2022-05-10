package sorting;

import java.util.Arrays;

public class ElementarySorting {

    public static void main(String[] args) {
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(new int[]{5, 4, 3, 2, 1})));
        System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(new int[]{5, 4, 3, 2, 1})));
    }

    /**
     * First, find
     * the smallest item in the array and exchange it with the first entry (itself if the first entry
     * is already the smallest). Then, find the next smallest item and exchange it with the second
     * entry. Continue in this way until the entire array is sorted. This method is called
     * selection sort because it works by repeatedly selecting the smallest remaining item.
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) min = j;
            }
            swap(i, min, array);
        }
        return array;
    }

    /**
     * Works by repeatedly swapping the adjacent elements if they are in the wrong order.
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) swap(j, j + 1, array);
            }
        }
        return array;
    }

    /**
     * As in selection sort, the items to the left of the current index are in sorted order during
     * the sort, but they are not in their final position, as they may have to be moved to
     * make room for smaller items encountered later. The array is, however, fully sorted when
     * the index reaches the right end.
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) swap(j, j - 1, array);
            }
        }
        return array;
    }

    /**
     * To exhibit the value of knowing properties of elementary sorts, we next
     * consider a fast algorithm based on insertion sort. Insertion sort is slow for large unordered
     * arrays because the only exchanges it does involve adjacent entries, so items
     * can move through the array only one place at a time. For example, if the item with the
     * smallest key happens to be at the end of the array, N1 exchanges are needed to get that
     * one item where it belongs. Shellsort is a simple extension of insertion sort that gains
     * speed by allowing exchanges of array entries that are far apart, to produce partially
     * sorted arrays that can be efficiently sorted, eventually by insertion sort.
     * <p>
     * The idea is to rearrange the array to give it the property that taking every hth entry
     * (starting anywhere) yields a sorted subsequence. Such an array is said to be h-sorted. Put
     * another way, an h-sorted array is h independent sorted subsequences, interleaved together. By h-sorting for some large values of h, we can move items in the array
     * long distances and thus make it easier to h-sort for smaller values of h. Using such a procedure for any sequence of values of
     * h that ends in 1 will produce a sorted array: that is shellsort.
     */
    public static int[] shellSort(int[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...

        while (h >= 1) {
            // h-sort the array.
            for (int i = h; i < N; i++) {
                // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    swap(j, j - h, array);
                }
            }
            h = h / 3;
        }
        return array;
    }

//    public static boolean less(int a, i)


    public static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
