package c257;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 返回二叉树中所有根节点到叶子节点的路径。
 */
class Solution {

    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null) {
            return result;
        }
        String s = String.valueOf(root.val);
        postOrder(root, s);

        return result;

    }

    private void postOrder(TreeNode node, String s) {

        if (node.left == null && node.right == null) {
            result.add(s);
            return;
        }

        if (node.left != null) {
            postOrder(node.left, s + "->" + String.valueOf(node.left.val));
        }

        if (node.right != null) {
            postOrder(node.left, s + "->" + String.valueOf(node.right.val));
        }

    }
}