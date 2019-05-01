package c1;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{3, 2, 4};
        s.twoSum(nums, 6);
    }
}
