package c617;

import node.TreeNode;

import java.util.List;

class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return this.mergeNode(t1, t2);

    }

    private TreeNode mergeNode(TreeNode node1, TreeNode node2) {

        // 终止条件
        if(node1 == null && node2 == null) {
            return null;
        }

        // 递归条件，一个不为 null 就继续遍历
        TreeNode node = new TreeNode((node1 == null?0:node1.val) + (node2 == null?0:node2.val));

        node.left = mergeNode(node1==null? null: node1.left, node2==null? null: node2.left);
        node.right = mergeNode(node1==null? null: node1.right, node2==null? null: node2.right);
        return node;
    }
}