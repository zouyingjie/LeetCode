package c938;

import node.TreeNode;

class Solution {
    private int sum = 0;
    private int L = 0;
    private int R = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        this.R = R;
        this.L = L;

        preOrder(root);
        return this.sum;

    }

    private void preOrder(TreeNode node) {

        if (node == null) {
            return;
        }

        if (node.val >= L && node.val <= R) {
            this.sum += node.val;
        }
        preOrder(node.left);
        preOrder(node.right);

    }
}