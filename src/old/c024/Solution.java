package old.c024;

import node.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode preNode = head;
        ListNode next = head.next;

        ListNode  nextHead = next.next;

        preNode.next = nextHead;
        next.next = preNode;

        ListNode result = next;

        while (nextHead != null && nextHead.next != null) {

            ListNode tmpNode = nextHead.next;
            preNode.next = tmpNode;
            nextHead.next = tmpNode.next;
            tmpNode.next = nextHead;

            preNode = nextHead;
            nextHead = nextHead.next;

        }


        return result;



    }


}
