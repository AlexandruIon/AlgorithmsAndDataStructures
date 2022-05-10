package sorting;


import java.util.Arrays;

/**
 * merging : combining two ordered arrays to make one larger ordered array.
 * This operation immediately leads to a simple recursive sort method known as mergesort
 * : to sort an array, divide it into two halves, sort the two halves (recursively), and
 * then merge the results. As you will see, one of mergesort’s most attractive properties is
 * that it guarantees to sort any array of N items in time proportional to N log N. Its prime
 * disadvantage is that it uses extra space proportional to N.
 */
public class MergeSort {

    public static void main(String[] args) {

        int[] array = new int[]{4, 5, 1, 2};
        mergeMine(array, 0, 2, 3);
        System.out.println(Arrays.toString(array));

        System.out.println("--------------------");

        int[] array2 = new int[]{5, 4, 2, 1};
        sort(array2);
        System.out.println(Arrays.toString(array2));
    }

    /**
     * puts the result of merging the subarrays a[lo..mid] with a[mid+1..hi] into a single ordered array, leaving the result in a[lo..hi].
     */

    private static int[] aux;


    public static void sort(int[] array) {
        aux = new int[array.length];

        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(array, lo, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }


    public static void merge(int[] a, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++)
            aux[i] = a[i];

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void mergeMine(int[] a, int lo, int mid, int hi) {
        int[] aux = new int[a.length];

        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }

        int index = lo;
        int middle = mid;

        while (index < hi) {
            if (lo > middle) {
                while (mid < hi) a[index++] = aux[mid++];
                break;
            }
            if (mid > hi) {
                while (lo < middle) a[index++] = aux[lo++];
                break;
            }
            if (aux[lo] < aux[mid]) a[index++] = aux[lo++];
            else if (aux[lo] > aux[mid]) a[index++] = aux[mid++];
        }
    }

}
