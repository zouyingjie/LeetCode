package com.zyj.c002;

import com.zyj.common.ListNode;

import java.util.List;

class Solution {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode node2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        addTwoNumbers(node1, node2);

    }

    /**
     * 节点的三种情况：
     * - node1 与 node2 都是空 val = 0 + bit
     * - node1 与 node2 都不是空 val = 1 + 2 + bit
     * - node1 为空  val = n2 + bit
     * - node2 为空  val = n1 + bit
     *
     * 相加的两种情况：
     * - 大于等于 10，进位
     * - 小于 10， 不进位
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode current = result;
        int bit = 0;

        while (l1 != null || l2 != null) {
            int num = 0;
            ListNode next = new ListNode();
            current.next = next;
            current = current.next;

            if (l1 == null) {
                num = num + l2.val + bit;
                l2 = l2.next;
            }else if (l2 == null) {
                num = num + l1.val + bit;
                l1 = l1.next;
            }else {
                num = l1.val + l2.val + bit;
                l1 = l1.next;
                l2 = l2.next;
            }

            if (num > 9) {
                num = num % 10;
                bit = 1;
            }else {
                bit = 0;
            }
            current.val = num;
        }

        if (bit == 1) {
            ListNode next = new ListNode(1);
            current.next = next;
        }

        return result.next;
    }


    // 方案 1：求和，问题，取值范围
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        long sum = add(l1, l2, 0);
//
//        int unit = (int) (sum % 10);
//        ListNode result = new ListNode(unit);
//        ListNode current = result;
//        sum = sum / 10;
//        while (sum > 0) {
//            ListNode node = new ListNode((int) (sum % 10));
//            current.next = node;
//            current = node;
//            sum = sum / 10;
//        }
//        return result;
//    }
//
//    private long add(ListNode node1, ListNode node2, int carryBit) {
//        if (node1 == null && node2 == null) {
//            return carryBit;
//        }
//
//        ListNode next1;
//        ListNode next2;
//
//        int num = 0;
//        if (node1 == null) {
//            num = node2.val + carryBit;
//            next1 = null;
//            next2 = node2.next;
//        } else if (node2 == null) {
//            num = node1.val + carryBit;
//            next2 = null;
//            next1 = node1.next;
//        } else {
//            num = node1.val + node2.val + carryBit;
//            next1 = node1.next;
//            next2 = node2.next;
//        }
//
//        if (num < 10) {
//            carryBit = 0;
//        } else {
//            num = num % 10;
//            carryBit = 1;
//
//        }
//        return num + 10 * add(next1, next2, carryBit);
//    }
}