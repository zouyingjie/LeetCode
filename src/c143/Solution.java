package c143;

import node.ListNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode p1 = head;
        ListNode p2 = head;


        // 双指针区分链表
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode p2Header = p1.next;
        ListNode p2Node = p2Header.next;

        boolean isOdd = false;
        if (p2.next == null) {
            isOdd = true;
        }

        // 反转第二部分链表

        while (p2Node != null) {
            ListNode tmp = p2Node.next;
            p2Node.next = p2Header;

            p2Header = p2Node;
            if (tmp == null) {
                break;
            }
            p2Node = tmp;
        }
        ListNode p2Tail = p1.next;
        p2Tail.next = null;
        p1.next = p2Header;
        System.out.println("1");

        // 构建新链表
        ListNode tail = head;
//        ListNode p1Header = head.next;
//        ListNode p1Node = p1Header.next;
        while (p2Header != null && tail.next != null) {
            ListNode nextP2Header = p2Header.next;
            ListNode next = tail.next;
            tail.next = p2Header;
            p2Header.next = next;
            p2Header = nextP2Header;
            tail = next;
//
//            if (p2Header == p2Tail) {
//                tail.next = p2Tail;
//                if (isOdd) {
//                    p1.next = null;
//                    tail.next.next = p1;
//                }
//                break;
//            }
        }
        tail.next = null;
        System.out.println("1");
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