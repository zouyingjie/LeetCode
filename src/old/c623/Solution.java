package old.c623;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    private int d = 0;
    private List<TreeNode> rowNodes;
    public TreeNode addOneRow(TreeNode root, int v, int d) {

        this.d = d;
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        bfs(nodes, 2);

        for (TreeNode node: rowNodes) {
            if(node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;

                node.left = new TreeNode(v);
                node.left.left = left;

                node.right = new TreeNode(v);
                node.right.right = right;
            }
        }
        return root;
    }

    private void bfs(List<TreeNode> nodes, int depth) {

        if (depth == d || nodes.size() == 0) {
            rowNodes = nodes;
            return;
        }

        List<TreeNode> list = new ArrayList<>();
        for (TreeNode node: nodes) {

            if(node != null) {
                list.add(node.left);
                list.add(node.right);
            }
        }

        depth ++;
        bfs(list, depth);

    }
}