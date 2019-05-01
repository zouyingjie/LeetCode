package c203;

import node.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        while (head.val == val) {
            head = head.next;
        }

        ListNode tmpNode = head.next;
        ListNode preNode = head;

        while (tmpNode != null) {
            if (tmpNode.val == val) {
                ListNode next = tmpNode.next;
                preNode.next = next;
                tmpNode = next;
            }else {
                preNode = tmpNode;
                tmpNode = tmpNode.next;
            }
        }
        return head;
    }
}
