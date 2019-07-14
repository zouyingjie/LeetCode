package c515;

import node.TreeNode;

import java.util.*;

class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {

        if (root == null) {
            return result;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        bfs(nodes);
        return result;

    }

    private void bfs(List<TreeNode> nodes) {


        List<TreeNode> nextLevelNodes = new ArrayList<>();

        int maxVal = Integer.MIN_VALUE;

        for (TreeNode node :
                nodes) {
            if (node != null) {
                maxVal = Math.max(node.val, maxVal);
                nextLevelNodes.add(node.left);
                nextLevelNodes.add(node.right);
            }
        }


        if (nextLevelNodes.size() > 0) {
            result.add(maxVal);
            bfs(nextLevelNodes);
        }

    }
}