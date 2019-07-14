package c023;

import node.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private ListNode result = null;
    public ListNode mergeKLists(ListNode[] lists) {

        List<ListNode> listNodes = Arrays.asList(lists);
        helper(listNodes);
        return this.result;

    }

    public void helper(List<ListNode> lists) {
        int len = lists.size();

        if (len == 0) {
            return;
        }

        if (len == 1) {
            this.result = lists.get(0);
            return;
        }

        ListNode result = null;

        List<ListNode> nodes = new ArrayList<>();

        for (int i = 0; i < len - 1; i += 2) {
            ListNode nod1 = lists.get(i);
            ListNode node2 = lists.get(i+1);
            result = mergeNode(nod1, node2);
            nodes.add(result);

            if ((i+2) == (len - 1)) {
                nodes.add(lists.get(i+2));
            }
        }

        if (nodes.size() == 1) {
            this.result = nodes.get(0);
            return;
        }
        helper(nodes);
    }

    public ListNode mergeNode(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        ListNode node = null;
        if (l2.val < l1.val) {
            node = new ListNode(l2.val);
            l2 = l2.next;
        }else {
            node = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode tail = node;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                tail.next = new ListNode(l2.val);
                tail = tail.next;
                l2 = l2.next;
            }else {
                tail.next = new ListNode(l1.val);
                tail = tail.next;
                l1 = l1.next;
            }
        }

        if (l1 == null) {
            tail.next = l2;
        }else {
            tail.next = l1;
        }
        return node;
    }
}