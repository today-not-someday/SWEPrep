package Arrays;
import java.util.HashMap;


public class TwoSum {

    public static void main(String[] args) {
        int[] num = new int[]{3, 2, 4};
        int[] res = twoSum(num, 6);
        System.out.println(res);
    }


    //Brute force
    public static int[] twoSumBrute(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};

            }
        }
        return new int[]{};

    }

    //Hash Map
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int f = nums[i];
            int second = target - f;

            if (set.containsKey(second))
                return new int[]{i, set.get(second)};
            else
                set.put(nums[i], i);
        }
        return new int[]{};

    }


}
