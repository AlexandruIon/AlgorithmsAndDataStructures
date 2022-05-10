import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int currentNumber = 0;
        for (int num : nums) {
            if (num != currentNumber) {
                return currentNumber;
            }
            currentNumber++;
        }
        return currentNumber;
    }

    public int missingNumbers(int[] nums) {
        Set<Integer> container = new HashSet<>();

        for (int num : nums) {
            container.add(num);
        }

        for (int i = 0; i < nums.length + 1; i++) {
            if (!container.contains(i)) return i;
        }

        return 0;
    }


    public int firstBadVersion(int n) {
        return badVersion(n, 0, n);
    }

    public int badVersion(int n, int low, int high) {
        if (low > high) {
            return low;
        }
        int mid = low + (high - low) / 2;
        if (isBadVersion(mid)) {
            return badVersion(n, low, mid - 1);
        } else {
            return badVersion(n, mid + 1, high);
        }
    }

    public boolean isBadVersion(int n) {
        return true;
    }


}
