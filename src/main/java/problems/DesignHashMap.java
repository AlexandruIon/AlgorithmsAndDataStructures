package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignHashMap {

    List<Tuple>[] array = new List[256];

    public DesignHashMap() {
        Arrays.fill(array, new ArrayList<>());
    }

    public void put(int key, int value) {
        int keyHash = computeHash(key);
        List<Tuple> asd = array[keyHash % array.length];
        for (int i = 0; i < asd.size(); i++) {
            if (asd.get(i).key == key) {
                asd.get(i).val=value;
                return;
            }
        }
        asd.add(new Tuple(key, value));
    }

    public int get(int key) {
        int keyHash = computeHash(key);
        List<Tuple> asd = array[keyHash % array.length];
        for (Tuple as : asd) {
            if (as.key == key) {
                return as.val;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int keyHash = computeHash(key);
        List<Tuple> asd = array[keyHash % array.length];
        for (int i = 0; i < asd.size(); i++) {
            if (asd.get(i).key == key) {
                asd.remove(i);
                break;
            }
        }
    }

    private int computeHash(int key) {
        return 31 * 7 + key;
    }

}

class Tuple {
    int key;
    int val;

    public Tuple(int key, int val) {
        this.key = key;
        this.val = val;
    }
}