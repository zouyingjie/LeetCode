package c328;

import node.ListNode;

import java.util.List;

class Solution {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode evenNode = head;
        ListNode oddNode = head.next;

        ListNode tmpOddHead = oddNode;

        while (evenNode!= null && oddNode != null) {
            ListNode oddNext = oddNode.next;

            if (oddNext != null) {
                evenNode.next = oddNext;
                oddNode.next = oddNext.next;
                oddNode = oddNode.next;
                evenNode = evenNode.next;

            }else {
                evenNode.next = null;
                oddNode = null;
            }

        }
        evenNode.next = tmpOddHead;
        return head;
    }
}