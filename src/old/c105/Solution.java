package old.c105;

import node.TreeNode;


public class Solution {

    private int[] preOrder;
    private int[] inOrder;
    private int len;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preOrder = preorder;
        this.inOrder = inorder;
        this.len = inorder.length;

        TreeNode root = this.findRoot(0, 0, inorder.length - 1);
        return root;
    }

    public TreeNode findRoot(int preStart, int inStart, int inEnd) {

        if (preStart > this.len - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[preStart]);

        int index = 0;
        for (int i = inStart; i <= inEnd; i ++) {
            if (inOrder[i] == root.val) {
                index = i;
                break;
            }
        }

        root.left = this.findRoot(preStart+1, inStart, index -1);
        root.right = this.findRoot(preStart + index - inStart + 1, index + 1, inEnd);
        return root;

    }
}
