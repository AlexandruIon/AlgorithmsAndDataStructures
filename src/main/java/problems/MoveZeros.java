package problems;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] asd = new int[]{0, 1, 0, 3, 12};
        moveZeroes(asd);
        System.out.println(Arrays.toString(asd));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }


    }

}
