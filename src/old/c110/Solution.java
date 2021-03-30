package old.c110;

import node.TreeNode;

public class Solution {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        inOrder(root);
        return this.result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            this.result = false;
            return;
        }else {
            inOrder(node.left);
            inOrder(node.right);
        }

    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int depth = 1 + Math.max(depth(node.left), depth(node.right));
        return depth;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(2);
//
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(3);
//
//        root.left.left.left = new TreeNode(4);
//        root.left.left.right = new TreeNode(4);
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = null;
        root.right.right = new TreeNode(3);

        s.isBalanced(root);
    }
}
