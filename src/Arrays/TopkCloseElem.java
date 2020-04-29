package Arrays;

import java.util.ArrayList;
import java.util.List;

public class TopkCloseElem {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(findClosestElements(nums, 4,3));
    }
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        //  using binary search

        int left = 0;
        // 注意此时的e不是下标，而是总的长度
        int right = arr.length-k;

        while (left < right){
            int mid = left + (right-left)/2;
            // 不取等且right = mid，这里是取lower bound，符合题意tie取numeber小的
            if (Math.abs(arr[mid]-x) > Math.abs(arr[mid+k]-x))
                left = mid+1;
            else
                right = mid;
        }

        List<Integer> res = new ArrayList();

        for (int i=left;i<left+k;i++){
            res.add(arr[i]);
        }

        return res;
    }

}
