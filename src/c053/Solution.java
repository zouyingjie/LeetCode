package c053;

class Solution {
    public static int maxSubArray(int[] nums) {

        int currentMax = nums[0];
        int sum = nums[0];

        int length = nums.length;

        for (int i = 1; i < length; i++) {
            int num = nums[i];
            if (sum + num < num) {
                sum = num;
                currentMax = Math.max(currentMax, num);
                continue;

            }else {
                sum += num;
                currentMax = Math.max(currentMax, sum);
            }
        }

        return currentMax;

    }

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }
}