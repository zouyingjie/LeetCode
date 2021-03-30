package old.c015;

import java.util.*;

public class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (nums.length < 3) {
            return this.result;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i ++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < length - 2; i ++) {
            for (int j = i + 1; j < length - 1; j ++) {
                set.remove(nums[i]);
                set.remove(nums[j]);
                if (set.contains(-(nums[i] + nums[i]))) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-(nums[i] + nums[j]));
                    this.result.add(list);
                }
                set.add(nums[i]);
                set.add(nums[j]);
            }
        }
        return result;
    }
}
