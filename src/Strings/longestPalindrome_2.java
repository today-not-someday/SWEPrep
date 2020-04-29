package Strings;

public class longestPalindrome_2 {
    public static void main(String[] args) {
        String s = "babad";
        // bab

        //caad -> aa
        //caaad -> aaa
        // abccbd -> bccb
        // abcccbd -> bcccb
        //bcccb

        System.out.println(longestPalindrome(s));


    }

    public static String longestPalindrome(String s) {
        int max = 0;
        String st="";
        int start=-1;
        int end=-1;
        for (int i = 0; i < s.length(); i++) {

            int lengthO= findMax(s,i,i); // ODD String
            int lengthE= findMax(s,i,i+1); // ODD String
            int l= Math.max(lengthO,lengthE);
            if(l>max) {
                max = Math.max(max, l);
                 start= i- (l-1)/2; // 1
                 end = i+ (l/2); // 5
            }
        }

        return s.substring(start,end+1);
    }

    private static int findMax(String s, int i, int j) {
        while (i>=0 && j< s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return j-i-1;
    }
}
