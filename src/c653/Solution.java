package c653;

import node.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * 计算平衡二叉树中相加是否有符合条件的值
     *
     * 第一种思路是遍历二叉树，记录下每个二叉树的值，已知记录 val, 如果存在 target - val 则满足条件
     * 好处是实现简单，但坏处是因为要记录每个值，因此需要额外的字典存储空间，其空间复杂度为 O(N)
     *
     * 另一种思路是遍历每一个值 val，然后搜索是否有 target - val 节点的存在，这样不需要额外的存储空间，但是每遍历一个节点都要
     * 查询一次二叉树，但因为是平衡二叉树，因此查找起来也不算耗时。
     */
//    private Map<Integer, Integer> map = new HashMap<>();
//    private boolean result = false;
//    private int target = 0;
//
//    public boolean findTarget(TreeNode root, int k) {
//
//        this.target = k;
//        this.inOrder(root);
//        return this.result;
//
//    }
//
//    private void inOrder(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//
//        if (map.containsKey(this.target - node.val)) {
//            this.result = true;
//            return;
//        }
//
//
//        map.put(node.val, 0);
//        inOrder(node.left);
//        inOrder(node.right);
//
//    }

    /**
     * 根据平衡二叉树的性质进行查找，空间上稍微小一点，速度上快一点
     * 最好的情况下是 O(1)
     * 最坏的情况是 O(NlogN)
      */
    private TreeNode root = null;
    private int target = 0;
    private boolean result = false;

    public boolean findTarget(TreeNode root, int k) {
        this.root = root;
        this.target = k;
        inOrder(root);
        return this.result;


    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        int num = target - node.val;
        if (findNum(this.root, node, num)){
            this.result = true;
            return;
        }

        inOrder(node.left);
        inOrder(node.right);
    }

    private boolean findNum(TreeNode node, TreeNode self, int num) {

        if (node == null) {
            return false;
        }
        if (node.val == num && node != self) {
            return true;
        }
        if (node.val > num) {
            return findNum(node.left, self, num);
        }else {
            return findNum(node.right, self, num);
        }
    }
}