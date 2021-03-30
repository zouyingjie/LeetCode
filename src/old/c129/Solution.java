package old.c129;

import node.TreeNode;

class Solution {

    private int result = 0;
    public int sumNumbers(TreeNode root) {

        dfs(root, 0);
        return this.result;
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) {
            return;
        }

        val = val * 10 + node.val;

        if (node.left == null && node.right == null) {
            this.result += val;
            return;
        }

        dfs(node.left, val);
        dfs(node.right, val);
    }
}