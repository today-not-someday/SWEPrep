package Graph;

import java.util.*;

public class BFSGraph {

    public class Graph{
    int v;
    int[] a=new int[5];
     LinkedList<Integer>[] adj;

     public Graph(int v){
         this.v=v;
         adj=new LinkedList[v];

         for (int i=0;i<v;i++){
             adj[i]=new LinkedList<>();
         }
     }

     public void addEdge(int v, int s){
         adj[v].add(s);
     }

     public void BFS(int k){

         boolean visited[]=new boolean[v];
         Queue<Integer> queue=new LinkedList<>();
         visited[k]=true;
         queue.add(k);

         while (!queue.isEmpty()){
             int s=queue.peek();
             Iterator<Integer> it= adj[s].listIterator();
             while (it.hasNext()==true){
                 int edges= it.next();
                 if (visited[edges]!=false){
                     visited[edges]=true;
                     queue.add(edges);
                 }
             }
         }
     }

    }
}
