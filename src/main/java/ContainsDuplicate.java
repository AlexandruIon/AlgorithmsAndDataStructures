import java.util.*;

public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 3, 4, 5}));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    // nlogn
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    //o(n)
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (values.containsKey(val)) {
                int j = values.get(val);
                if (Math.abs(i - j) <= k) return true;
            }
            values.put(val, i);
        }
        return false;
    }

}
