package c021;

import node.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode node = null;
        if (l2.val < l1.val) {
            node = new ListNode(l2.val);
            l2 = l2.next;
        }else {
            node = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode tail = node;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }else {
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            }
        }

        if (l1 == null) {
            tail.next = l2;
        }else {
            tail.next = l1;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        node4.next = new ListNode(3);
        node4.next.next = new ListNode(4);

        Solution s = new Solution();
        s.mergeTwoLists(node1, node4);
    }
}