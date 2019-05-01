package c897;

import node.TreeNode;

public class Solution {

    private TreeNode tmpNode = null;
    public TreeNode increasingBST(TreeNode root) {

        TreeNode result = root;

        while (result != null) {
            result = result.left;
            tmpNode = result;
        }

        root = result;
        return root;
    }

    private void inOrder(TreeNode node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);

        tmpNode.right = node;
        tmpNode.left = null;
        tmpNode = tmpNode.right;
        inOrder(node.right);

    }
}
