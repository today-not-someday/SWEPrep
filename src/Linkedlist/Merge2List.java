package Linkedlist;

public class Merge2List {

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

        ListNode rres = mergeTwoLists(l1, l2);
        System.out.println(rres.val);
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null & l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode headL1 = l1;
        ListNode headL2 = l2;
        ListNode newHead = null;
        ListNode pointer = newHead;

        while (headL1 != null && headL2 != null) {
            ListNode currentL1 = headL1;
            ListNode currentL2 = headL2;

            if (currentL1.val < currentL2.val) {
                if (newHead == null) {
                    newHead = currentL1;
                    pointer = newHead;
                } else {
                    pointer.next = currentL1;
                    pointer = pointer.next;

                }
                headL1 = headL1.next;
            } else {
                if (newHead == null) {
                    newHead = currentL2;
                    pointer = newHead;
                } else {
                    pointer.next = currentL2;
                    pointer = pointer.next;
                }
                headL2 = headL2.next;
            }
        }

        if (headL1 == null) {
            while (headL2 != null) {
                pointer.next = headL2;
                pointer = pointer.next;
                headL2 = headL2.next;
            }

        } else {
            while (headL1 != null) {
                pointer.next = headL1;
                pointer = pointer.next;
                headL1 = headL1.next;
            }
        }

        return newHead;
    }
}

