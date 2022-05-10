public class BinarySearch {

    public static void main(String[] args) {
        assert (rank(5, new int[]{0, 3, 5, 6}) == 2);
        assert (rankRecursive(5, new int[]{0, 3, 5, 6}) == 2);
        assert (rank(2, new int[]{0, 3, 5, 6}) == 1);
        assert (rankRecursive(2, new int[]{0, 3, 5, 6}) == 1);
        assert (rank(7, new int[]{0, 3, 5, 6}) == 4);
        assert (rankRecursive(7, new int[]{0, 3, 5, 6}) == 4);
    }

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (hi >= lo) {
            int mid = lo + (hi - lo) / 2;
            if (key > a[mid]) lo = mid + 1;
            else if (key < a[mid]) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    public static int rankRecursive(int key, int[] a) {
        return recursive(key, a, 0, a.length - 1);
    }

    public static int recursive(int key, int[] a, int lo, int hi) {
        int mid = lo + (hi - lo) / 2;
        if (lo > hi) return lo;
        if (key < a[mid]) return recursive(key, a, lo, mid - 1);
        else if (key > a[mid]) return recursive(key, a, mid + 1, hi);
        else return mid;
    }

}
