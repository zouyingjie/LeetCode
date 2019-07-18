package c637;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private List<Double> list = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        bfs(nodes);
        return this.list;

    }

    private void bfs(List<TreeNode> nodes) {
        if (nodes.size() == 0) {
            return;
        }

        double sum = 0;
        List<TreeNode> nextLevels = new ArrayList<>();

        for (TreeNode node: nodes) {
            if (node == null) {
                continue;
            }
            sum += node.val;
            nextLevels.add(node.left);
            nextLevels.add(node.right);
        }

        this.list.add(sum / nextLevels.size());
        bfs(nextLevels);
    }
}