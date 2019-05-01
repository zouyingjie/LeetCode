package c513;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {



    AtomicInteger num = new AtomicInteger();

    List<TreeNode> bottomLevel = new ArrayList<>();

    public int findBottomLeftValue(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();

        num.compareAndSet(10, 20);
        nodes.add(root);
        this.bfs(nodes);
        return this.bottomLevel.get(0).val;
    }

    private void bfs(List<TreeNode> nodes) {

        List<TreeNode> nextLevel = new ArrayList<>();
        int size = nodes.size();
        if (size == 0 ) {
            return;
        }

        for (int i = 0; i < size; i ++) {
            TreeNode node = nodes.get(i);
            if (node.left != null) {
                nextLevel.add(node.left);
            }

            if (node.right != null) {
                nextLevel.add(node.right);
            }
        }

        if (nextLevel.size() == 0) {
            this.bottomLevel = nodes;
        }else {
            this.bfs(nextLevel);
        }


    }
}