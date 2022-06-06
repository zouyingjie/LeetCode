package com.zyj.c108;

import com.zyj.common.TreeNode;

class Solution {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
//        return findRoot(0, nums.length - 1);
        return buildTree(0, nums.length - 1);
    }

    // 简单的解法
    public TreeNode buildTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = buildTree(start, end - 1);
        treeNode.right = buildTree(start + 1, end);
        return treeNode;

    }

    // 想复杂了
    private TreeNode findRoot(int start, int end) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int rootIndex = 0;
        if (end - start == 1) {
            rootIndex = end;
        } else {
            rootIndex = (int) Math.ceil(((double) end + start) / 2);
        }

        int val = nums[rootIndex];

        TreeNode node = new TreeNode(val);

        node.left = findRoot(start, rootIndex - 1);
        node.right = findRoot(rootIndex + 1, end);
        return node;
    }
}