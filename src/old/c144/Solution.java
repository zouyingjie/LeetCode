package old.c144;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        this.preOrder(root);
        return this.result;
    }

    private void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
}
