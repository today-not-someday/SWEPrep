package Graph;

import java.util.*;

public class CloneGraph {

    //     * Definition for undirected graph.

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        String s="s";



        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }

    ;

    public class Solution {

        public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
            Queue<UndirectedGraphNode> q = new LinkedList<>();
            HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
            UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
            q.add(node);
            map.put(node.label, copy);

            while (!q.isEmpty()) {

                UndirectedGraphNode nod = q.poll();

                for (UndirectedGraphNode n : nod.neighbors) {
                    if (map.containsKey(n.label)) {
                        map.get(nod.label).neighbors.add(map.get(n.label));
                    } else {
                        UndirectedGraphNode nCopy = new UndirectedGraphNode(n.label);
                        map.get(nod.label).neighbors.add(nCopy);
                        map.put(n.label, nCopy);
                        q.add(n);
                    }
                }
            }
            return copy;
        }
    }

}
