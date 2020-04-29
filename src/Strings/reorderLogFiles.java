package Strings;

import java.util.*;

public class reorderLogFiles {
    public static void main(String[] args) {
        String[] s = new String[]{
                "dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"};
        String[] ss = reorderLogFiles(s);


    }

    public static String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0) return null;
        Arrays.sort(logs, new MyComparator());
        return logs;
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String log1, String log2) {
            int idx1 = log1.indexOf(" ") + 1;
            int idx2 = log2.indexOf(" ") + 1;
            if (log1.charAt(idx1) >= 'a' && log1.charAt(idx1) <= 'z' &&
                    log2.charAt(idx2) >= 'a' && log2.charAt(idx2) <= 'z') {
                String tail1 = log1.substring(idx1);
                String tail2 = log2.substring(idx2);
                int temp = tail1.compareTo(tail2);
                System.out.println(tail1 + "---- " +tail2 + " -> " +temp);

                if (temp != 0) return temp;
                else return log1.compareTo(log2);
            }
            else if (log1.charAt(idx1) >= 'a' && log1.charAt(idx1) <= 'z') return -1;
            else if (log2.charAt(idx2) >= 'a' && log2.charAt(idx2) <= 'z') return 1;
            else return 0; // if both digit-logs, then keep the order
        }
    }
}

