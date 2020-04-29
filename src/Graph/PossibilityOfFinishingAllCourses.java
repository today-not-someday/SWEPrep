package Graph;

import java.util.*;

public class PossibilityOfFinishingAllCourses {


    public static void main(String[] args) {
        PossibilityOfFinishingAllCourses s = new PossibilityOfFinishingAllCourses();
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(2, 1));


        System.out.println(s.solve(3, B, C));
        List<Integer> A = new ArrayList<>();
        A.size();

    }

    public static class Graph {
        int v;
        LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v + 1];
            for (int i = 0; i <= v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int a, int b) {
            adj[a].add(b);
        }

        public LinkedList<Integer> getNeighbour(int v) {
            LinkedList<Integer> integers = adj[v];
            return integers;
        }
    }

    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        Graph graph = new Graph(A);
        for (int i = 0; i < B.size(); i++) {
            graph.addEdge(B.get(i), C.get(i));
        }

        Set<Integer> whiteSet = new HashSet<>();
        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blacckSet = new HashSet<>();

        for (int i = 0; i < A; i++) { // Add all vertice to WhiteSet
            whiteSet.add(i + 1);
        }

        while (whiteSet.size() > 0) {
            int current = whiteSet.iterator().next();
            if (dfs(current, whiteSet, greySet, blacckSet,graph))
                return 0;
        }

        return 1;
    }

    private boolean dfs(int current, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blacckSet, Graph graph) {

        moveVertice(current, whiteSet, greySet);

        for (int n : graph.getNeighbour(current)){
            if (blacckSet.contains(n))
                continue;
            if (greySet.contains(n))
                return true;
            if (dfs(n, whiteSet, greySet, blacckSet,graph))
                return true;
        }

        moveVertice(current, greySet, blacckSet );


        return false;
    }

    private void moveVertice(int current, Set<Integer> whiteSet, Set<Integer> greySet) {
        whiteSet.remove(current);
        greySet.add(current);
    }
}
