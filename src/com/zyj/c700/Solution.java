package com.zyj.c700;

import com.zyj.common.TreeNode;

public class Solution {

    private Integer val;
    private TreeNode result;

    public TreeNode searchBST(TreeNode root, int val) {
        this.val = val;
        search(root);
        return this.result;

    }

    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.val == val) {
            this.result = node;
            return;
        }
        if (node.val < this.val) {
            search(node.right);
        } else {
            search(node.left);
        }
    }
}
