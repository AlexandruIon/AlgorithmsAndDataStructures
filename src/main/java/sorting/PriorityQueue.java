package sorting;


/**
 * supports two operations: remove the maximum and insert.
 * <p>
 * elementary representations where one or
 * both of the operations take linear time, we consider a classic priority-queue implementation
 * based on the binary heap data structure, where items are kept in an array, subject
 * to certain ordering constraints that allow for efficient (logarithmic-time) implementations
 * of remove the maximum and insert
 * <p>
 * An important sorting algorithm known as heapsort also follows naturally from our heapbased
 * priority-queue implementations
 */
public class PriorityQueue {
}

class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N = 0;

    // if initial capacity max
    MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    // insert a key
    void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }


    Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    boolean isEmpty() {
        return N == 0;
    }

    int size() {
        return 1;
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

}