package com.zyj.c102;

import com.zyj.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }

        List<TreeNode> rootLevel = new ArrayList<>();
        rootLevel.add(root);
        bfs(rootLevel);
        return result;

    }


    private void bfs(List<TreeNode> nodes) {
        int length = nodes.size();
        if (length == 0) {
            return;
        }

        List<Integer> vals = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();

        for (int i = 0; i < length; i ++) {
            TreeNode node = nodes.get(i);
            vals.add(node.val);
            if (node.left != null) {
                nextLevel.add(node.left);
            }
            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }


        result.add(vals);
        bfs(nextLevel);
    }


}