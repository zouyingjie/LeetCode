package c114;

import node.TreeNode;

class Solution {
    public void flatten(TreeNode root) {

        return;
    }

    private TreeNode preOrder(TreeNode node) {


//          node.right = preOrder(node.left);
//          preOrder(node.right);
//        TreeNode tmpNode = node.right;
//        node.left

//        TreeNode rignt = node.right;
//        if (node.left != null) {
//            TreeNode tmpNode = dfs(node.left);
//            node.right = tmpNode;
//            while (tmpNode != null && tmpNode.right != null) {
//                tmpNode = tmpNode.right;
//            }
//            tmpNode.right=rignt;
//            node.left = null;
//            return node;
//        }else {
//            return dfs(node.right);
//        }
        return null;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);

//        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(3);

        s.flatten(root);
    }
}