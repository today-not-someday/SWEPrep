package Graph;

import java.util.ArrayList;

public class WordBoardSearch {

    public static void main(String[] args){

        Solution s= new Solution();
        ArrayList<String> A= new ArrayList<>();
        A.add("GFDABEGEE");
        A.add("DAEFEECCF");
        A.add("CAGGEDCDG");
        A.add("GCABEAAEA");
        A.add("CFGCGEEFB");
        A.add("ECAGGDFAD");

       System.out.println( s.exist(A,"DFFBFDACBF"));

    }


    public static class Solution {

        public int exist(ArrayList<String> A, String B) {
            int n = A.size();
            if (n==0) return 0;
            int m = A.get(0).length();
            if (m==0) return 0;
            if(B.length()==0) return 0;

            for (int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(A.get(i).charAt(j)==B.charAt(0))
                        if(dfs(A,B,i,j,0))
                            return 1;
                }
            }
            return 0;
        }

        public boolean dfs(ArrayList<String> A, String B, int i, int j, int index){

            if(i<0 || i>=A.size() || j<0 || j>= A.get(i).length())
                return false;

            if(index==B.length())
                return true;

            if(A.get(i).charAt(j)!=B.charAt(0))
                return false;

            if(dfs(A,B,i+1,j,index+1))
                return true;


            if(dfs(A,B,i-1,j,index+1))
                return true;

            if(dfs(A,B,i,j+1,index+1))
                return true;


            if(dfs(A,B,i,j-1,index+1))
                return true;

            return false;
        }


        private boolean dfs(ArrayList<String> a, int i, int j, int index, String b) {
            if (i < 0 || i >= a.size() || j < 0 || j >= a.get(i).length()) {
                return false;
            }

            if (index >= b.length()) {
                return true;
            }

            String s = a.get(i);
            char c = s.charAt(j);
            if (c != b.charAt(index)) {
                return false;
            }

            if (dfs(a, i, j + 1, index + 1, b)) {
                return true;
            }
            if (dfs(a, i, j - 1, index + 1, b)) {
                return true;
            }
            if (dfs(a, i + 1, j, index + 1, b)) {
                return true;
            }
            if (dfs(a, i - 1, j, index + 1, b)) {
                return true;
            }
            return false;
        }

    }

}
