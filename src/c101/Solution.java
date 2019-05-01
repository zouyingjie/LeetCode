package c101;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private List<TreeNode> nodes = new ArrayList<>();
    private boolean result = true;
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return this.result;
        }
        this.nodes.add(root);
        this.bfs();
        return this.result;
    }

    private void bfs() {
        List<TreeNode> levelNodes = new ArrayList<>();
        int size = this.nodes.size();
        for (int i = 0; i < size; i ++) {
            TreeNode node = this.nodes.get(i);
            if (node != null) {
                levelNodes.add(node.left);
                levelNodes.add(node.right);
            }
        }

        if (levelNodes.size() > 0) {
            if (isMirror(levelNodes)) {
                this.nodes = levelNodes;
                this.bfs();
            }else {
                this.result = false;
                return;
            }
        }

    }

    private boolean isMirror(List<TreeNode> levelNodes) {
        int size = levelNodes.size();
        for (int i = 0, j = size -1; i <= j ; i ++, j--) {
            TreeNode node1 = levelNodes.get(i);
            TreeNode node2 = levelNodes.get(j);
            if (node1 == null &&  node2 == null) {
                continue;
            }else if (node1 == null || node2 == null) {
                return false;
            }else if (node1.val != node2.val) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        s.isSymmetric(root);


    }
}
