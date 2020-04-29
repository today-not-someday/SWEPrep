package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class countIslands {
    static class Solution {

        public static void main(String[] args) {
            char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}};
            System.out.println(numIslands(grid));
        }

        public static int numIslands(char[][] grid) {


            int m = grid.length;
            int n = grid[0].length;


            int islands = 0;
            boolean visit[][] = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && grid[i][j]=='1') {
                        dfs(grid, visit, i, j);
                        islands++;
                    }
                }
            }
            return islands;
        }

        private static void dfs(char[][] grid, boolean[][] visit, int i, int j) {
            if (grid[i][j] == '0')
                visit[i][j] = true;

            if (visit[i][j]) {
                return;
            }

            visit[i][j] = true;


            int m = grid.length;
            int n = grid[0].length;
            int[] dX = new int[]{1, -1, 0, 0};
            int[] dY = new int[]{0, 0, 1, -1};

            for (int k = 0; k < dX.length; k++) {
                int nI = i + dX[k];
                int nj = j + dY[k];

                if (nI >= 0 && nI < m && nj >= 0 && nj < n) {
                    if (grid[nI][nj] == '1' && visit[nI][nj] == false) {
                        dfs(grid, visit, nI, nj);
                    }
                }
            }
            return;

        }
    }
}
//        Queue<Integer> queue = new LinkedList<>();
//
//            for(
//        int i = 0;
//        i<m;i++)
//
//        {
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 2) {
//                    queue.add((i * n) + j);
//                }
//                if (grid[i][j] == 1) {
//                    totalFOranges++;
//                }
//            }
//        }
//
//            while(!queue.isEmpty()&&totalFOranges >0)
//
//        {
//            min++;
//            int sizeQ = queue.size();
//            for (int k = 0; k < sizeQ; k++) {
//                int q = queue.poll();
//                int i = q / n;
//                int j = q % n;
//
//                for (int x = 0; x < dX.length; x++) {
//                    int nI = i + dX[x];
//                    int nJ = j + dY[x];
//                    if (nI >= 0 && nI < m && nJ >= 0 && nJ < n) {
//                        if (grid[nI][nJ] == 1) {
//                            grid[nI][nJ] = 2;
//                            totalFOranges--;
//                            queue.add((nI * n) + nJ);
//                        }
//                    }
//                }
//            }
//        }
//
//
//            if(totalFOranges >0)
//                return-1;
//            else return min;
//    }
//}
//}
