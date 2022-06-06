package com.zyj.c100;


import com.zyj.common.TreeNode;


class Solution {

    private boolean same = true;

    public boolean isSameTree(TreeNode p, TreeNode q) {
        preOrder(p, q);
        return same;
    }

    private void preOrder(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return;
        }
        if (node1 == null || node2 == null) {
            same = false;
            return;
        }

        if (node1.val != node2.val) {
            same = false;
            return;
        }

        preOrder(node1.left, node2.left);
        preOrder(node1.right, node2.right);

    }
}