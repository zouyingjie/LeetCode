package c863;

import node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private TreeNode target = null;
    private int K = 0;
    private int rootToTargetDistance = 0;
    private boolean targetInLeft = false;
    private List<Integer> list = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (K == 0) {
            list.add(target.val);
            return list;
        }

        this.K = K;
        this.target = target;
        findChildren(target, 0);
        if (target == root) {
            return list;
        }

        getRootDistance(root.left, 1, true);
        getRootDistance(root.right, 1, false);

        if (rootToTargetDistance == K) {
            list.add(target.val);
            return list;
        }
        if (rootToTargetDistance < K) { // 不同侧
            int diff = K - rootToTargetDistance;
            this.K = diff;
            if (this.targetInLeft) {
                findChildren(root.right, 1);
            }else {
                findChildren(root.left, 1);
            }
        }else { //同侧
            int diff = rootToTargetDistance - K;
            this.K = diff;
            if (this.targetInLeft) {
                findChildren(root.left, 1);
            }else {
                findChildren(root.right, 1);
            }
        }
        return this.list;
    }

    private void findChildren(TreeNode node, int distance) {
        if (node == null) {
            return;
        }

        if (distance == this.K) {
            this.list.add(node.val);
            return;
        }
        distance += 1;

        findChildren(node.left, distance);
        findChildren(node.right, distance);
    }

    private void getRootDistance(TreeNode node, int distance, boolean isLeft) {
        if (node == null) {
            return;
        }


        if (node == target) {
            this.rootToTargetDistance = distance;
            this.targetInLeft = isLeft;
            return;
        }

        distance += 1;
        getRootDistance(node.left, distance, isLeft);
        getRootDistance(node.right, distance, isLeft);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode target = new TreeNode(5);
        root.left = target;
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

    }
}
