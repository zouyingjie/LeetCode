package c198;

import java.util.HashMap;
import java.util.Map;

class Solution {


// 递归解法
//    private int[] nums;
//    private int result = Integer.MIN_VALUE;
//
//    private Map<Integer, Integer> map = new HashMap<>();
//    public int rob(int[] nums) {
//
//        this.nums = nums;
//        int len = nums.length;
//
//        if (len == 0) {
//            return 0;
//        }
//
//        if (len == 1) {
//            return nums[0];
//        }
//
//        if (len == 2) {
//            return Math.max(nums[0], nums[1]);
//        }
//
//        return Math.max(helper(len - 1), helper(len - 2));
//
//    }
//
//    private int helper(int index){
//        if (index < 0) {
//            return 0;
//        }
//
//        if (!map.containsKey(index)) {
//            int max = Math.max(helper(index - 2) + nums[index], helper(index - 1));
//            map.put(index, max);
//        }
//        return map.get(index);
//
//    }

    // 解法二：正向迭代，少了判断的时间，每次只运算即可
//    public int rob(int[] nums) {
//
//        int len = nums.length;
//
//        if (len == 0) {
//            return 0;
//        }
//
//        if (len == 1) {
//            return nums[0];
//        }
//
//        int[] sums = new int[len+1];
//
//        sums[0] = 0;
//        sums[1] = nums[0];
//
//
//        for (int i = 1; i < len; i ++) {
//            int num = nums[i];
//            sums[i+1] = Math.max(sums[i-1] + num, sums[i]);
//        }
//
//        return sums[len];
//    }

    //    // 解法三：斐波那契数列
//
//    public int rob(int[] nums) {
//        int len = nums.length;
//        if (len == 0) {
//            return len;
//        }
//
//        int prev1 = 0;
//        int prev2 = 0;
//
//        for (int num: nums) {
//            int tmpPre1 = prev1;
//
//
//        }
//    }
        private int[] nums;
        private int result = Integer.MIN_VALUE;

        private Map<Integer, Integer> map = new HashMap<>();

        public int rob(int[] nums) {

            this.nums = nums;
            int len = nums.length;

            if (len == 0) {
                return 0;
            }

            if (len == 1) {
                return nums[0];
            }

            map.put(0, 0);
            map.put(1, nums[0]);

            for(int i = 1; i < len; i ++) {
                int max = Math.max(map.get(i), map.get(i-1) + nums[i]);
                map.put(i+1, max);
            }

            return map.get(len);


        }

        private int helper(int index) {
            if (index < 0) {
                return 0;
            }

            if (!map.containsKey(index)) {
                int max = Math.max(helper(index - 2) + nums[index], helper(index - 1));
                map.put(index, max);
            }
            return map.get(index);

        }
}