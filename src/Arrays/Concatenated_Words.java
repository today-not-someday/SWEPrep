package Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }

    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            set.remove(word);
            if (dfs(word, set, res, "")) res.add(word);
            set.add(word);
        }
        return res;
    }

    private static boolean dfs(String word, HashSet<String> set, List<String> res, String prev) {
        if (set.contains(word))
            return true;

        int len = word.length();
        for (int i = 1; i < len; i++) {
            String prefix = word.substring(0, i);
            if (set.contains(prefix) && dfs(word.substring(i), set, res, prev + prefix)) {
                return true;
            }
        }

        return false;
    }
}
