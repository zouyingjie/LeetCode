package c543;

import node.TreeNode;

public class Solution {
    // 每个节点到其所有字节点的值
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateNodeHight(root);
        calculateDiameter(root);
        return result;
    }

    private int calculateNodeHight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int right = 0;
        int left = 0;
        if (node.right != null) {
            right =  1 + calculateNodeHight(node.right);
        }else {
            right = 0;
        }

        if (node.left != null) {
            left =  1 + calculateNodeHight(node.left);
        }else {
            left = 0;
        }

        node.val = Math.max(right, left);
        return node.val;
    }

    private void calculateDiameter(TreeNode node) {
        if (node == null) {
            return;
        }

        int right = 0;
        if (node.right != null) {
            right = node.right.val + 1;
        }

        int left = 0;
        if (node.left != null) {
            left = node.left.val + 1;
        }
        result = Math.max(left+right, result);
        calculateDiameter(node.left);
        calculateDiameter(node.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        s.diameterOfBinaryTree(root);




    }
}
