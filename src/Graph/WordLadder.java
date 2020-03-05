package Graph;


import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 */

public class WordLadder {

    public static void main(String[] args) {

        List<String> wordList = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        System.out.println(ladderLength("hit", "cog", wordList));
    }

    public static List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) return new ArrayList<>();

        List<List<String>> global = new ArrayList<>();

        Queue<GNodeInfo> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];

        ArrayList<String> s = new ArrayList<>();
        s.add(beginWord);

        GNodeInfo start = new GNodeInfo(beginWord, s);
        queue.add(start);

        while (!queue.isEmpty()) {
            GNodeInfo tem = queue.poll();

            if (tem.data.equals(endWord)) {
                global.add(tem.paths);
            }
else {
                for (int i = 0; i < wordList.size(); i++) {

                    if (isConnection(tem.data, wordList.get(i)) && !visited[i] && !wordList.get(i).equalsIgnoreCase(beginWord)) {
                        visited[i] = true;

                        List<String> list = new ArrayList<>(tem.paths);
                        list.add(wordList.get(i));
                        queue.add(new GNodeInfo(wordList.get(i), list));
                    }

                }
            }


        }

        return global;

    }

    private static boolean isConnection(String word, String word1) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {

            if (word.charAt(i) != word1.charAt(i)) count++;
        }
        return (count == 1) ? true : false;

    }


    public static class GNodeInfo {
        String data;
        List<String> paths;

        public GNodeInfo(String data, List<String> length) {
            this.data = data;
            this.paths = length;
        }
    }

}
