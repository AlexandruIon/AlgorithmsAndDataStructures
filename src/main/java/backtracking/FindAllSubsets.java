package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtracking(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList)); // add to the result list

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtracking(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println((subsets(nums)));
    }

}
