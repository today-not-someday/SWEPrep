package Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

class Solution {

    public static void main(String[] args) {

        String[] banned = new String[]{"a"};
        String s= "a, a, a, a, b,b,b,c, c";
        String ss = mostCommonWord(s,banned);
    }

        public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words= paragraph.split(" ");

            String wordsa = paragraph.replaceAll("\\W+" , " ").toLowerCase();
//                    .split("\\s+");

            HashSet<String> bannedMap= new HashSet<>();
        HashMap<String,Integer> map= new HashMap<>();

        for (String s:banned){
            bannedMap.add(s);
        }

        for (String s:words){
            String[] sA=s.split(",");
            String newS=s.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();
            if(!bannedMap.contains(newS)){
                map.put(newS,map.getOrDefault(newS,0)+1);
            }
        }
        int max = Integer.MIN_VALUE;
        String str="";
        Iterator<Map.Entry<String,Integer>> it= map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer> n= it.next();
            if(n.getValue()>max) {
                max = n.getValue();
                str = n.getKey();
            }
        }

        return str;
    }}
