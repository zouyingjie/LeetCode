package com.zyj.c098;

import com.zyj.common.TreeNode;

/**
 * 判断是否为二叉查找树
 *
 * left < node < right
 *
 * 可以采用 DFS 查找，如果违反了 left < node < right 表示不是
 */
public class Solution {

    private boolean result = true;

    public boolean isValidBST(TreeNode root) {
//        dfs(root);
        return result;
    }

    private void dfs(TreeNode node, int value) {
        if (node == null) {
            return;
        }

        int val = node.val;
        if (node.left != null && val <= node.left.val) {
            this.result = false;
            return;
        }

        if (node.right != null && val >= node.right.val) {
            this.result = false;
            return;
        }

//        dfs(node.left);
//        dfs(node.right);
    }
}
