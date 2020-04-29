package Arrays;


import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Tallabt {

    public static void main(String[] args){
        String s="my name is Jassim munir jassim jassim and and I am am taking taking interview";
        System.out.println(removeDupplicates(s));
    }

    public static String removeDupplicates(String str){
        if (str.length()==0)
            return "";
        String[] wordArr = str.split(" ");
        HashMap<String, Pair<Integer,Integer>> map = new HashMap<>();

        builfFrequencyMap(map, wordArr);

        modifyTheLastDupplicate(map, wordArr);

        StringBuffer sb= new StringBuffer();

        getFinalString(wordArr, sb);

        return sb.toString();
    }

    private static void getFinalString(String[] wordArr, StringBuffer sb) {
        for (String word:wordArr){
            if (word.equalsIgnoreCase("0"))
                continue;
            else {
                sb.append(word);
                sb.append(" ");
            }
        }
    }

    private static void modifyTheLastDupplicate(HashMap<String, Pair<Integer, Integer>> map, String[] wordArr) {
        for(Map.Entry<String,Pair<Integer,Integer>> entry :map.entrySet()){
            if (entry.getValue().getKey()>1){
                wordArr[entry.getValue().getValue()]="0";
            }
        }
    }

    private static void builfFrequencyMap(HashMap<String, Pair<Integer, Integer>> map, String[] wordArr) {
        for(int i = 0;i<wordArr.length;i++){
            if(map.containsKey(wordArr[i].toLowerCase())){
                int count= map.get(wordArr[i]).getKey();
                map.put(wordArr[i],new Pair<>(++count,i));
            }else{
                map.put(wordArr[i],new Pair<>(1,i));
            }
        }
    }
}
