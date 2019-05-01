package c111;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private int minDepthNum = 0;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return minDepthNum;
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        minDepthNum++;
        this.bfs(treeNodes);
        return minDepthNum;
    }

    public void bfs(List<TreeNode> treeNodes) {
        int length = treeNodes.size();
        List<TreeNode> nodes = new ArrayList<>();

        for (int i = 0; i < length; i ++) {
            TreeNode node = treeNodes.get(i);

            if (node.left == null && node.right == null) {
                return;
            }
            if (node.left != null) {
                nodes.add(node.left);
            }
            if(node.right != null) {
                nodes.add(node.right);
            }

        }
        minDepthNum ++;
        this.bfs(nodes);

    }
}