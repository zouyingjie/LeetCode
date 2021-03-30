package old.c404;

import node.TreeNode;

public class Solution {

    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root == null && root.right == null) {
            return root.val;
        }
        inOrder(root.left, true);
        inOrder(root.right, false);

        return this.sum;
    }

    private void inOrder(TreeNode node, boolean isLeft) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null && isLeft) {
            this.sum += node.val;
        }

        inOrder(node.left, true);
        inOrder(node.right, false);
    }

}
