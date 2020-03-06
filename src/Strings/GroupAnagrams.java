package Strings;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] strArr = s.toCharArray();
            Arrays.sort(strArr);
            String sortedS = String.valueOf(strArr);

            if (!map.containsKey(sortedS)) map.put(sortedS, new ArrayList<>());
            map.get(sortedS).add(s);

        }

        Iterator<Map.Entry<String, List<String>>> e = map.entrySet().iterator();
        while (e.hasNext()) {
            ans.add(e.next().getValue());
        }


        return ans;
    }
}
