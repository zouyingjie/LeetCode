package c532;

import java.util.*;

public class Solution {
    private int result = 0;

    public int findPairs(int[] nums, int k) {

        int length = nums.length;
        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        if (k == 0) {
            for (int i = length - 1; i >= 0; i--) {
                if (k == 0) {
                    if (!list.contains(nums[i]) && map.containsKey(nums[i])) {
                        this.result += 1;
                        list.add(nums[i]);
                    } else {
                        map.put(nums[i], 0);
                    }
                }
            }
        } else {
            for (int i = length - 1; i >= 0; i--) {
                if (map.containsKey(nums[i] + k)) {
                    result += 1;
                    map.remove(nums[i] + k);
                }
                map.put(nums[i], 0);
            }
        }

        return this.result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findPairs(new int[]{3, 1, 4, 1, 5}, 2);
    }
}
