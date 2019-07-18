package c143;

import node.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    List<Integer> nums = new ArrayList<>();
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode tmpHead = head;

        while (tmpHead != null) {
            nums.add(tmpHead.val);
            tmpHead = tmpHead.next;
        }


        int size = nums.size();

        int i = 0;
        int j = size - 1;

        while (i < j) {

        }

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Solution s = new Solution();
        s.reorderList(node1);
    }
}