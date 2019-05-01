package c783;

import node.TreeNode;

public class Solution {
    /**
     * 本质上是计算两个节点之间的最小差值
     *
     * 平衡二叉树的性质，则一个节点与之相差的最小的节点有如下几种可能：
     *
     * 1. 左子节点
     * 2. 右子节点
     * 3. 左子节点的最右子节点
     * 4. 右子节点的最左子节点
     */
    private int result = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return this.result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            this.result = Math.min(this.result, node.val - node.left.val);

            TreeNode tmpNode = node.left.right;
            if (tmpNode != null) {
                while (true) {
                    if (tmpNode != null) {
                        // 左子节点的右子树，因此用 node 的值减去节点值
                        this.result = Math.min(this.result, node.val - tmpNode.val);
                    }else {
                        break;
                    }
                    tmpNode = tmpNode.right;
                }
            }

            inOrder(node.left);
        }

        if (node.right != null) {
            this.result = Math.min(this.result, node.right.val - node.val);
            TreeNode tmpNode = node.right.left;
            if (tmpNode != null) {
                while (true) {
                    if (tmpNode != null) {
                        // 右子节点的左子树，因此用 节点值减去 node 值
                        this.result = Math.min(this.result, tmpNode.val - node.val);
                    }else {
                        break;
                    }
                    tmpNode = tmpNode.left;
                }
            }
            inOrder(node.right);
        }
    }
}
