package c145;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> result = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        this.postOrder(root);
        return this.result;
    }

    private void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        result.add(node.val);
    }
}