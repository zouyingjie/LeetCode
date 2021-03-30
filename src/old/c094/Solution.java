package old.c094;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        this.inOrder(root);
        return this.result;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        result.add(node.val);
        inOrder(node.right);
    }
}