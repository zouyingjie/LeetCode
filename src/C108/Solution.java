package C108;

import node.TreeNode;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;

        return findRoot(0, len-1, nums);


    }

    private TreeNode findRoot(int start, int end, int[] nums) {

        if (start > end) {
            return null;
        }

        int rootIndex = 0;
        if (end - start == 1) {
            rootIndex = end;
        }else {
            rootIndex = (int) Math.ceil( ((double) end + start) / 2);
        }


        int val = nums[rootIndex];

        TreeNode node = new TreeNode(val);

        node.left = findRoot(start, rootIndex - 1, nums);
        node.right = findRoot(rootIndex + 1, end , nums);
        return node;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sortedArrayToBST(new int[]{0,1,2,3,4,5});
    }
}