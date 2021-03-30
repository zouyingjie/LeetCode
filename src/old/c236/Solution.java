package old.c236;

import node.TreeNode;

public class Solution {

    private TreeNode p;
    private TreeNode q;
    private TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        this.p = p;
        this.q = q;

        this.containNodes(root);
        return this.result;

    }

    private boolean containNodes(TreeNode node) {
        if (node == null) {
            return false;
        }

        if (node == p || node == q) {
            if (containNodes(node.left) || containNodes(node.right)) {
                this.result = node;
                return true;
            }
        }else {
            if (containNodes(node.left) && containNodes(node.right)) {
                this.result = node;
                return true;
            }
        }
        return false;
    }
}
