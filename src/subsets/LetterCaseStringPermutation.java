package subsets;

import java.util.*;

class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permutations.add(str);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                int n = permutations.size();
                for (int k = 0; k < n; k++) {
                    char[] chrs = permutations.get(k).toCharArray();
                    if (Character.isLowerCase(chrs[i]))
                        chrs[i] = Character.toUpperCase(chrs[i]);
                    else
                        chrs[i] = Character.toLowerCase(chrs[i]);
                    permutations.add(String.valueOf(chrs));
                }
            }
        }


        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
