package subsets;

import java.util.*;

class SubsetWithDuplicates {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int end = 0;
        int start;
        for (int i = 0; i < nums.length; i++) {
            start = 0;

            if (i > 0 && nums[i] == nums[i - 1])
                start = end + 1;
            end = subsets.size() - 1;
            for (int j = start; j <= end; j++) {
                List<Integer> list = new ArrayList<>(subsets.get(j));
                list.add(nums[i]);
                subsets.add(list);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[]{1, 3, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[]{1, 5, 3, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}
