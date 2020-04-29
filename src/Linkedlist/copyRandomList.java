package Linkedlist;

import java.util.HashMap;

public class copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    public static void main(String[] args) {
//        [[7,null],[13,0],[11,4],[10,2],[1,0]]
//        [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;


        Node n = copyRandomList(node1);
        n.toString();
    }

    public static Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node old = head;
        Node newOld = new Node(old.val);
        map.put(old, newOld);


        while (old != null) {
            newOld.random = findClonedNode(old.random, map);
            newOld.next=findClonedNode(old.next,map);
            old=old.next;
            newOld=newOld.next;
        }
        return map.get(head);
    }

    private static Node findClonedNode(Node old, HashMap<Node, Node> map) {
        if(old==null)
            return null;

        if (map.containsKey(old))
            return map.get(old);
        else {
            Node node = new Node(old.val);
            map.put(old, node);
            return node;
        }
    }

}
