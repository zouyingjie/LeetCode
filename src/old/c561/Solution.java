package old.c561;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {

        int length = nums.length;
        Arrays.sort(nums);

        int result = 0;

        for (int i = 0; i < length; i += 2) {
            result += nums[i];
        }

        return result;
    }
}
