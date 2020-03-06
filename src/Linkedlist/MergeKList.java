package Linkedlist;

import java.util.PriorityQueue;

public class MergeKList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] mains) {

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(7);

        ListNode l3 = new ListNode(3);
        ListNode l4 = null;
        l2.next = new ListNode(8);

//        ListNode res = mergeKLists(new ListNode[]{l1, l2, l3});
        ListNode res = mergeKLists(new ListNode[]{l4});
        System.out.println(res.val);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode result = new ListNode(-1);
        ListNode prev = result;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            if (curr != null)
                minHeap.add(lists[i]);
        }

        System.out.println(minHeap.peek().val);


        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            prev.next = min;
            prev = prev.next;
            if (min.next != null)
                minHeap.add(min.next);
        }

        return result.next;
    }
}

