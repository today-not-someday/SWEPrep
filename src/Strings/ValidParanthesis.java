package Strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParanthesis {

    public static void main(String[] mains) {
//        String s = "()[]{}";
        String s = "){";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) return true;
        if (s.length() == 1) return false;


        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        char[] openP = {'(', '{', '['};
        char[] closedP = {')', '}', ']'};

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement == (map.get(c)))
                    continue;
                else return false;

            } else
                stack.push(c);
        }
        if (stack.size() > 0) return false;
        return true;
    }
}
