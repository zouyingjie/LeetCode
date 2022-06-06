package com.zyj.c109;

import com.zyj.common.ListNode;
import com.zyj.common.TreeNode;


class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    /**
     * 快慢指针找到 mid
     *
     * 另一种取巧的方式，将链表转为数组，然后用 108 中的方法实现，但数据量大时是个灾难。
     * @param head
     * @param tail
     * @return
     */
    public TreeNode buildTree(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode treeNode = new TreeNode(slow.val);
        treeNode.left = buildTree(head, slow);
        treeNode.right = buildTree(slow.next, tail);
        return treeNode;

    }
}