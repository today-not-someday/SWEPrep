package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class KnightOnChessBoard {


    public static void main(String[] args) {
        KnightOnChessBoard s = new KnightOnChessBoard();
        System.out.println(s.knight(8, 8, 1, 1, 8, 8));

    }

    public class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {

        int shortestPath = 0;
        boolean[][] visited = new boolean[A+1][B+1];
        int[] dX = {-2, -2, 2, 2, 1, 1, -1, -1};
        int[] dY = {1, -1, 1, -1, 2, -2, 2, -2};

        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(C, D));

        while (!queue.isEmpty()){

            int nodesAtThisLevel=queue.size();

            for (int i=0;i<nodesAtThisLevel;i++){

                Coordinate node= queue.poll();
                visited[node.x][node.y]=true;

                if (node.x==E && node.y==E){
                    break;
                }


                for (int k=0;k<dX.length;k++){
                    int posX=node.x+dX[k];
                    int posy=node.y+dY[k];

                    if (posX<=0 || posX>A ||
                    posy<=0 || posy>B || visited[posX][posy]==true)
                        continue;
                    else {
                        queue.add(new Coordinate(posX,posy));
                        visited[posX][posy]=true;
                    }
                }
            }
            shortestPath ++;
        }

        return shortestPath-1;

    }
}
