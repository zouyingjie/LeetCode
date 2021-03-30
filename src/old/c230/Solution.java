package old.c230;


import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {

//    private int result = 0;
//    private int k = 0;
//    private int index = 0;
//
//    public int kthSmallest(TreeNode root, int k) {
//
//        this.k = k;
//        inOrder(root);
//        return this.result;
//
//    }
//
//    public void inOrder(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        inOrder(node.left);
//        if (index == k) {
//            this.result = node.val;
//            return;
//        }else {
//            index ++;
//        }
//        inOrder(node.right);
//    }

    private List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        inOrder(root);
        return list.get(k-1);
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
}