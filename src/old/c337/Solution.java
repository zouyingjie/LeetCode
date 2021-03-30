package old.c337;

import node.TreeNode;

public class Solution {

//     解法一：递归求解，实际测试 1000 ms
//    public int rob(TreeNode root) {
//
//        return Math.max(helper(root, true), helper(root, false));
//
//    }
//
//    private int helper(TreeNode node, boolean robParent) {
//
//        if (node == null) {
//            return 0;
//        }
//
//        int val = 0;
//        if (robParent) {
//            val = helper(node.left, false)  + helper(node.right, false);
//        }else {
//            val = Math.max(node.val + helper(node.left, true) + helper(node.right, true), helper(node.left, false) + helper(node.right, false));
//        }
//        return val;
//    }

//    解法二：空间换时间，实际测试 7ms
//    private Map<TreeNode, Integer> robParentMap = new HashMap<>();
//    private Map<TreeNode, Integer> notRobParentMap = new HashMap<>();
//
//    public int rob(TreeNode root) {
//        return Math.max(helper(root, true), helper(root, false));
//    }
//
//    private int helper(TreeNode node, boolean robParent) {
//
//        if (node == null) {
//            return 0;
//        }
//
//        int val = 0;
//        if (robParent) {
//            if (!robParentMap.containsKey(node)) {
//                val = helper(node.left, false)  + helper(node.right, false);
//                robParentMap.put(node, val);
//            }
//            return robParentMap.get(node);
//
//        }else {
//            if (!notRobParentMap.containsKey(node)) {
//                val = Math.max(node.val + helper(node.left, true) + helper(node.right, true), helper(node.left, false) + helper(node.right, false));
//                notRobParentMap.put(node, val);
//            }
//            return notRobParentMap.get(node);
//        }
//    }

    // 解法三：后序遍历，实际测试 1ms
    public int rob(TreeNode root) {

        int[] nums = postOrder(root);
        return Math.max(nums[0], nums[1]);

    }

    private int[] postOrder(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        // 第 1 个值为不读父节点时的大致，第二个为读父节点
        int[] nums1 = postOrder(node.left);
        int[] nums2 = postOrder(node.right);

        int num1 = nums1[1] + nums2[1];
        int num2 = Math.max(num1, node.val + nums1[0] + nums2[0]);
        return new int[]{num1, num2};

    }

    private int helper(int num) {
        if (num <= 2) {
            return 0;
        }
        return helper(num-1) + helper(num - 2) + helper(num - 3) + 1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.helper(100));
        System.out.println(s.helper(100000));
        System.out.println(s.helper(20000000));
    }
}
