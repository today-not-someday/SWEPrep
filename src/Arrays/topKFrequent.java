package Arrays;

import java.util.*;

class Solution1 {
    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words, 2));
        int[] a=new int[]{3 ,1, 2, 5, 3};
        repeatedNumber(a);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<Map.Entry<String, Integer>>((a, b) -> {
            if (a.getValue() == b.getValue())
                return a.getKey().compareTo(b.getKey());
            return b.getValue() - a.getValue();
        });

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            queue.add(it.next());
        }

        for (int i =0;i<k;i++){
            res.add(queue.remove().getKey());
        }
        return res;
    }

    public static int[] repeatedNumber(final int[] A) {
        int arr[]= new int[2];
        for(int i = 0; i < A.length; i++) {
            int index= Math.abs(A[i])-1;
            if(A[index] < 0)
                arr[0]= index+1;
            else
                A[index]= -1*A[index];
        }
        for(int i= 0; i < A.length; i++)
            if(A[i] > 0)
                arr[1]= i+1;

        return arr;
    }
}
