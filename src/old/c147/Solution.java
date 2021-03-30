package old.c147;

import node.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {

        ListNode tmpHead = head;

        ListNode preNode = null;

        while (head != null) {
            ListNode next = head.next;
            if (next != null) {
                if (head.val >= next.val) {
                    swap(preNode, head, next);
                }
            }
        }
        return null;
    }

    private void swap(ListNode preNode, ListNode node1, ListNode node2) {
        ListNode tmpNext = node2.next;
        node1.next = tmpNext;
        node2.next = node1;

        if (preNode != null) {
            preNode.next = node2;
        }

    }
}