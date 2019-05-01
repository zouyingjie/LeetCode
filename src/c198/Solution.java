package c198;

class Solution {
    public int rob(int[] nums) {
        int num1 = 0;
        int num2 = 0;
        int length = nums.length;
        int i = 0, j = 0;
        for ( ;j < length; ) {
            num1 += nums[i];
            num2 += nums[j];
            i += 2;
            j += 2;
        }

        if (i < length) {
            num1 += nums[i];
        }

        return Math.max(num1, num2);
    }
}