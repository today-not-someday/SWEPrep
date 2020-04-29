package subsets;

import java.util.*;

class GenerateParentheses {

    static class PString {
        String str;
        int open;
        int close;

        public PString(String str, int o, int c) {
            this.str = str;
            this.open = o;
            this.close = c;
        }
    }

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        Queue<PString> queue = new LinkedList<>();
        queue.add(new PString("", 0, 0));
        while (!queue.isEmpty()) {
            PString pString = queue.poll();
            if (pString.open == num && pString.close == num) {
                result.add(pString.str);
            }

            if (pString.open < num)
                queue.add(new PString(pString.str + "(", pString.open + 1, pString.close));
            if (pString.close < pString.open)
                queue.add(new PString(pString.str + ")", pString.open, pString.close + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }
}
