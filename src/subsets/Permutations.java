package subsets;

import java.util.*;

class Permutations {

    public static List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> perm = new LinkedList<>();
        perm.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n=perm.size();
            for (int j=0;j<n;j++){
               List<Integer> oldPerm=perm.poll();
               for (int k=0;k<=oldPerm.size();k++){
                   List<Integer> newPerm=new ArrayList<>(oldPerm);
                   newPerm.add(k,nums[i]);
                   if (newPerm.size()==nums.length)
                       result.add(newPerm);
                   else
                       perm.add(newPerm);
               }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Permutations.findPermutations(new int[]{1, 3, 5});
        System.out.print("Here are all the permutations: " + result);
    }
}
