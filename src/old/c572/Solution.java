package old.c572;

import node.TreeNode;

public class Solution {

    private TreeNode t = null;
    private boolean result = false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        this.t = t;
        inOrder(s);
        return this.result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if(isEqual(node, t)){
            this.result = true;
            return;
        }else {
            inOrder(node.left);
            inOrder(node.right);
        }

    }

    private boolean isEqual(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val == node2.val) {
            return isEqual(node1.left, node2.left) && isEqual(node1.right, node2.right);
        } else {
            return false;
        }
    }
}
