package c199;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 基于层次遍历的一个变体
 * 取每层的最右边值
 */
class Solution {

    private List<List<Integer>> levelNodeVals = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return result;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        this.bfs(nodes);

        int len = this.levelNodeVals.size();
        for (int i = 0; i < len; i ++) {
            List<Integer> valList = this.levelNodeVals.get(i);
            int val = valList.get(valList.size() - 1);
            result.add(val);
        }
        return result;

    }

    public void bfs(List<TreeNode> treeNodes) {
        int length = treeNodes.size();
        if (length == 0) {
            return;
        }

        List<TreeNode> nodes = new ArrayList<>();
        List<Integer> nodeVals = new ArrayList<>();

        for (int i = 0; i < length; i ++) {
            TreeNode node = treeNodes.get(i);
            nodeVals.add(node.val);

            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        this.levelNodeVals.add(nodeVals);
        this.bfs(nodes);

    }
}