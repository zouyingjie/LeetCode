package c234;

import node.ListNode;

import java.util.Stack;

class Solution {
    /**
     * 检查链表是否为回文链表
     * 解决思路为:
     *
     * 1. 利用双指针获取后版
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode node1 = head;
        ListNode node2 = head;

        while (node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }

        Stack<ListNode> stack = new Stack();
        ListNode node = head;
        while (node != node1) {
            stack.push(node);
            node = node.next;
        }

        if (node2.next != null) {
            stack.push(node1);
        }

        ListNode next = node1.next;

        while (next != null) {

            if (!stack.isEmpty() && stack.pop().val == next.val) {
                next = next.next;
                continue;
            }
            return false;
        }
        return true;

//
//        ListNode tmpNode = node1.next;
//        ListNode node = tmpNode;
//
//        int val1 =0;
//        int val2 =0;
//        while (head != tmpNode) {
//
//        }
//
//        return val1 == val2;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(0);
        node.next.next = new ListNode(1);
        Solution s = new Solution();
        boolean palindrome = s.isPalindrome(node);
        System.out.println(palindrome);
    }
}