package old.c448;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int length = nums.length;
        List<Integer> result = new ArrayList<>();
        if (length == 0) {
            return result;
        }

        int[] newNums = new int[length];
        boolean hasN = true;

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num == length) {
                hasN = false;
            }
            if (num >= 1 && num < length) {
                newNums[num] = 1;
            }
        }


        for (int i = 1; i < length; i++) {
            int num = newNums[i];
            if (num == 0) {
                result.add(i);
            }
        }

        if (hasN) {
            result.add(length);
        }
        return result;

    }
}