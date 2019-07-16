package c034;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int len = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i ++) {
            if (nums[i] > target) {
                break;
            }
            if (nums[i] == target) {
                list.add(i);
            }

        }

        int[] result = new int[2];
        if (list.size() == 0) {
            result[0] = -1;
            result[1] = -1;
        }else {
            result[0] = list.get(0);
            result[1] = list.get(list.size() - 1);
        }
        return result;
    }
}