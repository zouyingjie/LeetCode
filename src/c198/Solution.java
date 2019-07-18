package c198;

class Solution {

    private int[] nums;
    private int result = Integer.MIN_VALUE;
    public int rob(int[] nums) {

        int length = nums.length;
        this.nums = nums;
        if (length == 0) {
            return 0;
        }
        if (length == 2) {
            return nums[0];
        }
        if (length == 0) {
            Math.max(nums[0], nums[1]);
        }
        helper(length-1, 0);
        helper(length-2, 0);
        return this.result;

    }

    private void helper(int index, int val){

        if (index < 0) {
            result = Math.max(result, val);
            return;
        }
        helper(index-2, val + nums[index]);

    }
}