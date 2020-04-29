package Graph;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;

public class CommutableIslands {

    public static void main(String[] args){

        CommutableIslands s= new CommutableIslands();
        ArrayList<ArrayList<Integer>> A= new ArrayList<>();
        A.add(new ArrayList<Integer>(Arrays.asList(1, 2, 10)));
        A.add(new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
        A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 9 )));
//        A.add(new ArrayList<Integer>(Arrays.asList(1, 4, 3)));


        System.out.println( s.solve(3,A));

    }

    class Graph {
        int v;
        Segments[] segements;

        public Graph(int v) {
            this.v = v;
            segements = new Segments[v+1];
            for (int i = 1; i <= v; i++) {
                segements[i] = new Segments();
                segements[i].parent = i;
                segements[i].rank = 0;
            }
        }

        public void union(int node1, int node2) {
            int p1 = find(node1);
            int p2 = find(node2);

            if (segements[p1].rank < segements[p2].rank)
                segements[p1].parent = p2;
            else if (segements[p1].rank > segements[p2].rank)
                segements[p2].parent = p1;
            else {
                segements[p2].parent = p1;
                segements[p1].rank++;
            }

        }

        public int find(int node) {
            int parent = segements[node].parent;
            if (parent != node)
                segements[node].parent = find(parent);

            return segements[node].parent;
        }
    }

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        Graph graph = new Graph(A);

        Collections.sort(B, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(2) - o2.get(2);
            }
        });

        int ans = 0;

        for (ArrayList<Integer> edge : B) {
            int parent1 = graph.find(edge.get(0));
            int parent2 = graph.find(edge.get(1));

            if (parent1 != parent2) {
                ans += edge.get(2);
                graph.union(edge.get(0), edge.get(1));
            }
        }
        return ans;
    }

    private class Segments {
        int parent;
        int rank;
    }
}
