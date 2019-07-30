package c95;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new ArrayList();
        }
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();


        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        if(start == end){
            nodes.add(new TreeNode(start));
            return nodes;
        }

        List<TreeNode> leftNodes, rightnodes;
        for (int i = start; i <= end; i ++) {
            leftNodes = helper(start, i - 1);
            rightnodes = helper(i + 1, end);



            for (TreeNode leftNode: leftNodes) {
                for (TreeNode rightNode: rightnodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    nodes.add(root);
                }
            }
        }

        return nodes;
    }
}
