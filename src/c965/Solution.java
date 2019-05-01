package c965;

import node.TreeNode;

public class Solution {
    private int rootValue = 0;
    private boolean result = true;
    public boolean isUnivalTree(TreeNode root) {
        this.rootValue = root.val;
        this.inOrder(root);
        return this.result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.val != this.rootValue) {
            this.result = false;
            return;
        }

        inOrder(node.left);
        inOrder(node.right);
    }
}
