package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class largestNumber {


    public static void main(String[] args) {
        largestNumber(new int[]{3, 30, 34, 5, 9});
    }


    public static String largestNumber(final int[] A) {

        String s[] = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            s[i] = String.valueOf(A[i]);
        }

        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });


        StringBuilder sb = new StringBuilder();
        for(String ss: s){
            sb.append(ss);
        }
        return sb.toString();
    }
}
