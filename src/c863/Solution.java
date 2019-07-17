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
        return null;
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
