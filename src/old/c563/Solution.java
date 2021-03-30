package old.c563;

import node.TreeNode;

public class Solution {
    /**
     * 求倾斜度
     *
     * 本质上是计算每个节点左子树节点之和和右子树节点之和相减的绝对值
     *
     * 遍历整个节点，计算每个节点的左子树之和和右子树之和，然后相减即可
     */
    private int tilt = 0;
    public int findTilt(TreeNode root) {
        if (root == null) {
            return tilt;
        }
        subTreeSum(root);
        return this.tilt;

    }
    private int subTreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSubTreeSum = 0;
        int rightSubTreeSum = 0;
        if (node.left != null) {
            leftSubTreeSum = subTreeSum(node.left);
        }

        if (node.right != null) {
            rightSubTreeSum = subTreeSum(node.right);
        }

        int value = Math.abs(leftSubTreeSum - rightSubTreeSum);
        this.tilt += value;
        return leftSubTreeSum + rightSubTreeSum + node.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        s.findTilt(root);
    }
}
