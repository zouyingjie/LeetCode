package c501;

import node.TreeNode;

import java.util.*;

public class Solution {

    private Map<Integer, Integer> map = new HashMap<>();
    private int maxFrequency = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        List<Integer> list = new ArrayList<>();


        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                list.add(entry.getKey());
            }
        }

        int length = list.size();
        int[] nums = new int[length];

        for (int i = 0; i < length; i ++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        int val = map.getOrDefault(node.val, 0) + 1;
        map.put(node.val, val );
        maxFrequency = Math.max(val, maxFrequency);
        inOrder(node.left);
        inOrder(node.right);
    }


}
