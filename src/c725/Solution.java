package c725;

import node.ListNode;

import java.util.concurrent.atomic.AtomicLong;

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode tail = root;
        AtomicLong l = null;

        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len ++;
        }

        int num = len % k;

        ListNode[] result = null;
        if (num > k) {
            result = new ListNode[len/3 +1];
        }
        return null;
    }
}
