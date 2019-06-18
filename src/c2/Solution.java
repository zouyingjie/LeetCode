package c2;

import node.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode tail = result;

        int isopsephy = 0;

        while (l1 != null || l2 != null) {

            int value1 = l1 == null ? 0:l1.val;
            int value2 = l2 == null ? 0:l2.val;

            int val = value1 + value2 + isopsephy;

            if (val > 9) {
                val = val % 10;
                isopsephy = 1;

            }else {
                isopsephy = 0;
            }

            tail.val = val;

            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
            if (l1 == null && l2 == null) {
                if (isopsephy > 0) {
                    tail.next = new ListNode(isopsephy);
                    tail = tail.next;
                }
                break;
            }
            tail.next = new ListNode(0);
            tail = tail.next;

        }

        return result;
    }
}