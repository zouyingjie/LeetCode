package c104;


import node.TreeNode;

/**
 * 计算二叉树的深度
 *
 * 递归方式: 思路比较简单，时间复杂度为 O(N)
 * 深度遍历
 * 广度遍历
 */

class Solution {

    private int maxLength = 0;
    private int minLength = 0;

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        calculateLength(root, 0);
        return this.maxLength;
    }

    private void calculateLength(TreeNode node, int length) {

        if (node == null) {
            this.maxLength = Math.max(this.maxLength, length);
            return;
        }

        length ++;
        calculateLength(node.left, length);
        calculateLength(node.right, length);

    }

}