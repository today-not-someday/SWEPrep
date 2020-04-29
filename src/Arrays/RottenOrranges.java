package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrranges {
    static class Solution {

        public static void main(String[] args) {
            int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
            System.out.println(orangesRotting(grid));
        }

        public static int orangesRotting(int[][] grid) {
            int[] dX = new int[]{1, -1, 0, 0};
            int[] dY = new int[]{0, 0, 1, -1};
            int m = grid.length;
            int n = grid[0].length;
            int totalFOranges = 0;
            int min = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.add((i * n) + j);
                    }
                    if (grid[i][j] == 1) {
                        totalFOranges++;
                    }
                }
            }

            while (!queue.isEmpty() && totalFOranges > 0) {
                min++;
                int sizeQ = queue.size();
                for (int k = 0; k < sizeQ; k++) {
                    int q = queue.poll();
                    int i = q / n;
                    int j = q % n;

                    for (int x = 0; x < dX.length; x++) {
                        int nI=i + dX[x];
                        int nJ=j + dY[x];
                        if (nI>= 0 && nI < m && nJ >= 0 && nJ < n) {
                            if (grid[nI][nJ] == 1) {
                                grid[nI][nJ] = 2;
                                totalFOranges--;
                                queue.add((nI * n) + nJ);
                            }
                        }
                    }
                }
            }


            if (totalFOranges > 0)
                return -1;
            else return min;
        }
    }
}
