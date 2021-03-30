package old.c114;

import node.TreeNode;

class Solution {

    public void flatten(TreeNode root) {
        postOrder(root);
    }

    private TreeNode postOrder(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode left = postOrder(node.left);
        TreeNode right = postOrder(node.right);

        if (left != null) {

            TreeNode tmpLeft = left;
            while (tmpLeft.right != null) {
                tmpLeft = tmpLeft.right;
            }

            tmpLeft.right = right;
            node.right = left;
            node.left = null;
        }
        return node;
    }
}