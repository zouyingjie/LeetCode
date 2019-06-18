package c061;

import node.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail = head;
        int len = 1;

        while (tail.next != null) {
            len ++;
            tail = tail.next;
        }

        int newK = 0;
        if (k > len) {
            newK = Math.abs(len - k % len);
        }else {
            newK = Math.abs(len - k);
        }

        while (newK != 0) {
            tail.next = head;
            tail = head;
            head = head.next;
            tail.next = null;
            newK --;
        }

        return head;

    }
//    public ListNode rotateRight(ListNode head, int k) {
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//        head = reverseList(head);
//
//        ListNode tail = head;
//        while (tail.next != null) {
//            tail = tail.next;
//        }
//
//
//        while (k != 0) {
//            tail.next = head;
//            tail = head;
//            head = head.next;
//            tail.next = null;
//            k --;
//        }
//
//        return reverseList(head);
//
//    }

    private ListNode reverseList(ListNode node) {

        ListNode next = null;
        ListNode preNode = null;

        while (node.next != null) {
            next = node.next;
            node.next = preNode;
            preNode = node;
            node = next;
        }

        node.next = preNode;
        return node;
    }
}
