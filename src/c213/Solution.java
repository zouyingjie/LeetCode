package c213;

class Solution {

    private int[] nums;

    private int[] tailNums; // 从最后一个开始抢
    private int[] headNums; // 从头抢

    public int rob(int[] nums) {

        this.nums = nums;
        int len = nums.length;

        tailNums = new int[len];
        headNums = new int[len];

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }

        for (int i = 0; i < len; i ++) {
            headNums[i] = -1;
            tailNums[i] = -1;
        }
        return Math.max(helper(len - 1, true), helper(len - 2, false));

    }

    private int helper(int index, boolean flag){
        if (index < 0) {
            return 0;
        }

        if (flag && index == 0) {
            return 0;
        }

        if (flag) {
            if(tailNums[index] == -1) {
                int max = Math.max(helper(index - 2, flag) + nums[index], helper(index - 1, flag));
                tailNums[index] = max;
            }
            return  tailNums[index];

        }else {
            if(headNums[index] == -1) {
                int max = Math.max(helper(index - 2, flag) + nums[index], helper(index - 1, flag));
                headNums[index] = max;
            }
            return  headNums[index];

        }

    }

    public static void main(String[] args) {
        String A = "aa";
        String B = "aa";
        System.out.println(A == B);
        System.out.println(A.equals(B));
    }
}