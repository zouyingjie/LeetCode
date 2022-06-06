package com.zyj.c145;

import com.zyj.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return result;
    }

    private void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        result.add(treeNode.val);
    }
}