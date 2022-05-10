package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllSubsets2 {

    public static void main(String[] args) {

        // Main List for storing all subsets
        List<List<Integer>> subset = new ArrayList<>();

        // Input array list
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);

        findSubsets(subset, input, new ArrayList<>(), 0);

        // Comparator is used so that all subset get
        // sorted in ascending order of values
        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)) {
                    continue;
                } else {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });


        // Printing Subset
        for (int i = 0; i < subset.size(); i++) {
            for (int j = 0; j < subset.get(i).size(); j++) {
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();
        }

    }

    private static void findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index) {

        // base condition
        if (index == nums.size()) {
            subset.add(output);
            return;
        }

        // not including value which is at index
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);

        // include value which is at index
        output.add(nums.get(index));

        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }

    private static void printSubsets(char[] set) {
        int n = set.length;

        for (int i = 0; i < (1 << n); i++) {
            System.out.println("{");
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0)
                    System.out.println(set[j] + " ");
            }
            System.out.println("}");
        }
    }


}
