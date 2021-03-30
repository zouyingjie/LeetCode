package old.c747;

import java.util.*;

class Solution {
    public int dominantIndex(int[] nums) {

        if (nums == null) {
            return -1;
        }

        int length = nums.length;

        if (length < 2) {
            return -1;
        }
        int[] newNums = Arrays.copyOfRange(nums, 0, length);
        Arrays.sort(newNums);

        int maxNum = newNums[length - 1];
        if (newNums[length-2] * 2 > maxNum) {
            return -1;
        }
        for (int i = 0; i < length; i ++) {
            if (nums[i] == maxNum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1};

        Solution s = new Solution();
        int res = s.dominantIndex(nums);
        System.out.println(res);
    }
}