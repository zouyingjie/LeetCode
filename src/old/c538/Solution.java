package old.c538;

import node.TreeNode;

class Solution {
    public TreeNode convertBST(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode node, int val) {
        if (node == null) {
            return val;
        }
        node.val += helper(node.right, 0) + val;
        return helper(node.left, node.val);

    }

    private int right(TreeNode node, int sum) {

        if (node == null) {
            return 0;
        }

        left(node, node.left);
        node.val += right(node.right, 0) + sum;
        return node.val;
    }

    private void left(TreeNode parent, TreeNode node) {
        if (node != null) {
            node.val = parent.val + node.val + right(node.right, 0);
            left(node, node.left);
            left(node, node.right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(13);
        root.left = node1;
        root.right = node2;
        s.convertBST(root);
    }
}