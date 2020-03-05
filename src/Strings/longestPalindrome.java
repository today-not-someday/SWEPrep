package Strings;

public class longestPalindrome {

    public static void main(String[] mains) {
        String s = "babac";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) return "";

        int max = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Start from middle and expand outwards

            int l1 = checkP(i, i, s);  // for cases like bab
            int l2 = checkP(i, i + 1, s); // for cases like baab

            int l = Math.max(l1, l2);

            if (l > max) {
                max = l;
                start = i - ((l - 1) / 2);
                end = i + (l / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public static int checkP(int i, int j, String s) {

        while  (i >= 0 && j < s.length() && s.charAt(i) == (s.charAt(j))) {
                i--;
                j++;
            }

        return j - i - 1;
    }
}
