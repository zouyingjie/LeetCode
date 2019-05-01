package c169;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        int length = nums.length;
        for (int i = 0; i < length; i ++) {
            int times = map.getOrDefault(nums[i], 0) + 1;
            if (times > length/2) {
                return times;
            }
            map.put(nums[i], times);
        }

        return 0;
    }
}