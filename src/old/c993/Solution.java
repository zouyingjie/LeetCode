package old.c993;

import node.TreeNode;

public class Solution {

    private int X, Y, depthX, depthY;
    private TreeNode parentX, parentY;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.left == null || root.right == null) {
            return false;
        }

        this.X = x;
        this.Y = y;

        inOrder(root, 0);

        if (depthY == depthX && parentX != parentY) {
            return true;
        }
        return false;
    }

    private void inOrder(TreeNode node, int depth) {

        if (node.left == null && node.right == null) {
            return;
        }

        depth += 1;

        if (node.left != null) {
            if (node.left.val == this.X) {
                this.depthX = depth;
                this.parentX = node;
            }else if (node.left.val == this.Y) {
                this.depthY = depth;
                this.parentY= node;
            }else {
                inOrder(node.left, depth);
            }
        }

        if (node.right != null) {
            if (node.right.val == this.X) {
                this.depthX = depth;
                this.parentX = node;
            }else if (node.right.val == this.Y) {
                this.depthY = depth;
                this.parentY= node;
            }else {
                inOrder(node.right, depth);
            }
        }
    }
}
