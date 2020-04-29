package Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = (end + start) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }


        return -1;

    }

}
