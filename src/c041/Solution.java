package c041;

import java.util.Arrays;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length==0 || nums[0] > 1 || nums[length-1] <= 0) {
            return 1;
        }

        for (int i = 0; i < length; i ++) {
            int num = nums[i];
            if (num <= 0) {
                continue;
            }else {
                if (num > 1 && nums[i-1] < 0) {
                    return 1;
                }else if (num > 1 && i >= 1 && num-1 > nums[i-1]) {
                    return nums[i-1] +1;
                }
            }

        }
        return nums[length-1]+1;
    }

}