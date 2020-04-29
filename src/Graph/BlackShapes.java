package Graph;

import java.util.ArrayList;

public class BlackShapes {



        public static void main(String[] args){


            BlackShapes s= new BlackShapes();
            ArrayList<String> A= new ArrayList<>();
            A.add("OOXO0");
            A.add("OXXOO");
            A.add("OOO0X");

            System.out.println( s.black(A));

        }

        public int black(ArrayList<String> A) {

            int count = 0;
            int n = A.size();
            int m = A.get(0).length();
            boolean visited[][] = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (A.get(i).charAt(j) == 'X' && visited[i][j] != true) {
                        count++;
                        countBlack(A, i, j, count, visited);
                    }
                }
            }
            return count;
        }

        private void countBlack(ArrayList<String> a, int i, int j, int count, boolean[][] visited) {
            int n = a.size();
            int m = a.get(0).length();

            if (i < 0 || i >= n || j < 0 || j >= m) {
                return;
            }

            if (a.get(i).charAt(j) != 'X' || visited[i][j]==true)
                return;

            visited[i][j] = true;

            countBlack(a, i + 1, j, count, visited);
            countBlack(a, i - 1, j, count, visited);
            countBlack(a, i, j + 1, count, visited);
            countBlack(a, i, j - 1, count, visited);

        }
    }


