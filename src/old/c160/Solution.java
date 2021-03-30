package old.c160;

import node.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // discuss 中的一种解法
        // 无限遍历，直到相遇。因为 A 和 B 两个链表长度不同
        // 一方到达结尾后，立马切换到另一个 head，这样随着遍历次数的增加，最终差值会抹平 到达同一个节点
        // 该节点要么为 null，要么是相交的点
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;


        while( a != b){

            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

//    private ListNode res = null;
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode reverseNode = this.reverseList(headA);
//
//        // 2. 连接两个链表
//        headA.next = headB;
//
//        // 3. 检测是否有环
//
//        ListNode slow = reverseNode.next;
//        if (slow == null || slow.next == null) {
//            return res;
//        }
//
//        ListNode fast = reverseNode.next.next;
//        boolean hasCycle = false;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (fast == slow) {
//               ListNode head = reverseNode;
//               while (head != slow) {
//                   slow = slow.next;
//                   head = head.next;
//               }
//               res = head;
//               break;
//
//            }
//        }
//        headA.next = null;
//        reverseList(reverseNode);
//        return res;
//    }

    private ListNode reverseList(ListNode node) {
        ListNode tailA = node.next;
        node.next = null;
        ListNode preNode = node;

        while (tailA != null) {
            ListNode next = tailA.next;
            tailA.next = preNode;
            preNode = tailA;
            tailA = next;
        }
        return preNode;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(0);
        ListNode node8 = new ListNode(1);

        node6.next = node7;
        node7.next = node8;
        node8.next = node3;

        Solution s = new Solution();
        s.getIntersectionNode(node1, node6);

    }

}