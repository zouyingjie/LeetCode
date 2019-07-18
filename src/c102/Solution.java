package c102;


import node.TreeNode;

import java.util.ArrayList;
import java.util.List;


class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return result;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        this.bfs(nodes);
        return result;

    }

    public void bfs(List<TreeNode> treeNodes) {
        int length = treeNodes.size();
        if (length == 0) {
            return;
        }

        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> nodeVals = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            TreeNode node = treeNodes.get(i);
            nodeVals.add(node.val);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        this.result.add(nodeVals);
        this.bfs(nodes);

    }
}
