package Arrays;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 1, 6, 8, 5, 3, 7};
        int[] temp = new int[arr.length];

        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(temp);
    }

    private static void mergeSort(int[] arr, int low, int high, int[] temp) {
        if (low >= high)
            return;
        int middle = (low + high) / 2;
        mergeSort(arr, low, middle, temp);
        mergeSort(arr, middle + 1, high, temp);
        merge(arr, low, middle, high, temp);
    }

    private static void merge(int[] arr, int low, int middle, int high, int[] temp) {

    int[] leftA=new int[high-middle];
    int[] rightA=new int[middle-low+1];

    for (int i=low;i<leftA.length;i++){
        leftA[i]=arr[low+i];
    }
    for (int i=middle;i<rightA.length;i++){
        rightA[i]=arr[i];
    }









//
//        int index = low;
//        int highStart = middle + 1;
//        int lowleft=low;
//
//        while (lowleft <= middle && highStart <= high) {
//            if (arr[lowleft] <= arr[highStart]) {
//                temp[index] = arr[lowleft];
//                lowleft++;
//            } else {
//                temp[index] = arr[highStart];
//                highStart++;
//            }
//            index++;
//        }
//        if (lowleft <= middle) {
//            while (lowleft <= middle) {
//                temp[index] = arr[low];
//                index++;
//                lowleft++;
//            }
//        }
//        if (highStart <= high) {
//            while (highStart <= high) {
//                temp[index] = arr[highStart];
//                index++;
//                highStart++;
//            }
//        }
    }
}
