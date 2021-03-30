package old.c112;

import node.TreeNode;


class Solution {
    private boolean hasPath = false;
    private int sum = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        this.sum = sum;
        this.dfs(root, 0);
        return this.hasPath;
    }

    public void dfs(TreeNode node, int num) {
        if(this.hasPath) {
            return;
        }
        num += node.val;
        if (node.left == null && node.right == null) {
            if (num == this.sum){
                this.hasPath = true;
            }
        }
        if (node.left != null ){
            this.dfs(node.left, num);
        }
        if (node.right != null ) {
            this.dfs(node.right, num);
        }

    }
}