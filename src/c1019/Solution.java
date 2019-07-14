package c1019;

import node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] nextLargerNodes(ListNode head) {

        List<Integer> list = new ArrayList();
        ListNode node = head;

        while(node != null) {
            ListNode next = node.next;
            int largerVal = 0;

            while(next != null) {
                if(next.val > node.val) {
                    largerVal = next.val;
                    break;
                }
                next = next.next;
            }
            list.add(largerVal);
            node = node.next;
        }

        int[] nums = new int[list.size()];

        for (int i = 0; i < nums.length; i ++ ) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}
