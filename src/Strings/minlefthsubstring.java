package Strings;

public class minlefthsubstring {

//    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//    Input: S = "ADOBECODEBANC", T = "ABC"
//    Output: "BANC"

    public static void main(String[] args) {
//        String s = "AAAADDDOBECODEBANC";
//        String t = "ABC";
//        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

        System.out.println(findMinSubArray(7,new int[]{2, 1, 5, 2, 8}));
    }
    public static int findMinSubArray(int S, int[] arr) {
        int windowStart=0;
        int minL=Integer.MAX_VALUE;;
        int windowSum=0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum+=arr[windowEnd];

            while(windowSum>=S){
                minL=Math.min(minL,windowEnd-windowStart+1);
                windowSum-=arr[windowStart];
                windowStart++;
            }

        }
        return minL;
    }
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > 2) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
    public static String minWindow(String s, String t) {
        int[] map = new int[128];

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map[c]++;
        }
        int left = 0;
        int right = 0;
        int minL = Integer.MAX_VALUE;
        int plength = t.length();
        int counter = plength;
        int minStart = 0;

        while (right < s.length()) {
            int endC = s.charAt(right);
            map[endC]--;
            if (map[endC] >= 0)
                counter--;

            while (counter == 0) {
                if (minL > right - left + 1) {
                    minL = right - left + 1;
                    minStart = left;
                }
                int beginC = s.charAt(left);
                map[beginC]++;
                if (map[beginC] > 0) counter++;
                left++;
            }
            right++;
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minL);
    }

}
