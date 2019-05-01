package c445;

import node.ListNode;

import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 基本思路是计算出两个链表对应的值，相加后在转为字符串生成链表。
 * 遇到最主要的问题就是边界溢出，最终必须始终 BigInteger 类型计算，
 * 这样实际的运行效率非常低
 *
 * 亟待优化
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        BigInteger num1 = getListNodeNum(l1);
        BigInteger num2 = getListNodeNum(l2);


        BigInteger sum = num1.add(num2);

        String sumStr = String.valueOf(sum);
        System.out.println(sum);

        int length = sumStr.length();
        int firstNodeVal = Character.getNumericValue(sumStr.charAt(0));
        ListNode result = new ListNode(firstNodeVal);

        ListNode tail = result;

        for (int i = 1; i < length; i ++) {
            ListNode newNode = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
            tail.next = newNode;
            tail = newNode;
        }
        return result;
    }

    public BigInteger getListNodeNum(ListNode node) {
        BigInteger number = BigInteger.valueOf(0);

        BigInteger ten =  BigInteger.valueOf(10);
        while (node != null) {
            number = number.multiply(ten);
            number = number.add(BigInteger.valueOf(node.val));
            node = node.next;
        }

        return number;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;

        ListNode l11 = new ListNode(7);
        s.addTwoNumbers(l1, l11);

    }
}