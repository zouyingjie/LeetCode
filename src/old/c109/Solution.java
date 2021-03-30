package old.c109;

import node.ListNode;
import node.TreeNode;


class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        return this.findRoot(head, null);

    }

    private TreeNode findRoot(ListNode head, ListNode tail) {

        if (head == tail) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(slow.val);
        node.left = findRoot(head, slow);
        node.right = findRoot(slow.next , tail);
        return node;

    }
//    public TreeNode sortedListToBST(ListNode head) {
//
//        List<Integer> list = new ArrayList<>();
//
//        ListNode node = head;
//        while (node != null) {
//            list.add(node.val);
//            node = node.next;
//        }
//
//        int len = list.size();
//
//        return findRoot(0, len-1, list);
//
//
//    }
//
//    private TreeNode findRoot(int start, int end, List<Integer> list) {
//
//        if (start > end) {
//            return null;
//        }
//
//        int rootIndex = 0;
//        if (end - start == 1) {
//            rootIndex = end;
//        }else {
//            rootIndex = (int) Math.ceil( ((double) end + start) / 2);
//        }
//
//
//        int val = list.get(rootIndex);
//
//        TreeNode node = new TreeNode(val);
//
//        node.left = findRoot(start, rootIndex - 1, list);
//        node.right = findRoot(rootIndex + 1, end , list);
//        return node;
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n2.next = n4;
        s.sortedListToBST(n0);
    }

}