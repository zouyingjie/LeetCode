package c098;

import node.TreeNode;

class Solution {

    private boolean isValid = true;
    private long maxVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        inOrder(root);
        return this.isValid;

    }

    private void inOrder(TreeNode node){
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (node.val <= maxVal) {
            this.isValid = false;
            return;
        }else {
            maxVal = node.val;
        }
        inOrder(node.right);
    }
}