package old.c222;

import node.TreeNode;

class Solution {

    private int count;
    public int countNodes(TreeNode root) {

        inOrder(root);
        return count;

    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        count ++;
        inOrder(node.right);
    }
}