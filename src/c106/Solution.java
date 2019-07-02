package c106;

import node.TreeNode;

class Solution {

    private int[] inOrder;
    private int[] postOrder;
    private int len;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.inOrder = inorder;
        this.postOrder = postOrder;
        this.len = inorder.length;

        return findRoot(len-1, 0, len-1);

    }

    public TreeNode findRoot(int postEnd, int inStart, int inEnd) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(this.postOrder[postEnd]);

        int inIndex = 0;

        for (int i = inStart; i <= inEnd; i ++) {
            if (this.inOrder[i] == root.val) {
                inIndex = i;
            }
        }

        root.left = findRoot(postEnd - inEnd + inIndex - 1, inStart, inIndex-1);
        root.right = findRoot(postEnd - 1, inIndex + 1, inEnd);
        return root;
    }
}