package old.c019;

import node.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        return  null;

//        if(head == null || head.next == null) {
//            return null;
//        }

//        ListNode slow = head;
//        ListNode fast = head.next;
//
//        int slowIndex = 1;
//        int fastIndex = 2;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            slowIndex += 1;
//            fastIndex += 2;
//        }
//
//        ListNode start = null;
//        ListNode end = null;
//        int startIndex = 1;
//        int endIndex = slowIndex;
//
//        if (n > slowIndex) {
//            start = head;
//            end = slow;
//
//        }else {
//            start = slow;
//            end = fast;
//            startIndex = slowIndex;
//            endIndex =fastIndex;
//        }
//
//        while (startIndex + n < slowIndex)
//




//        return revertList(head);
    }

    private ListNode revertList(ListNode node) {

        if (node.next == null) {
            return node;
        }

        ListNode preNode = node;
        ListNode next = node.next;
        preNode.next = null;

        while (next != null && next.next != null) {
            ListNode tmpNode = next.next;
            next.next = preNode;
            preNode = next;
            next = tmpNode;
        }

        next.next = preNode;
        return next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        Solution s = new Solution();
        ListNode node = s.removeNthFromEnd(head, 1);
        System.out.println(1);
    }
}
