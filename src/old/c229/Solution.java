package old.c229;

import java.util.*;

class Solution {

//    Set<Integer> integers = new HashSet<>();
//    public List<Integer> majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int length = nums.length;
//        for (int i = 0; i < length; i ++) {
//            int times = map.getOrDefault(nums[i], 0) + 1;
//            if (times > length/3 ) {
//                integers.add(nums[i]);
//            }
//            map.put(nums[i], times);
//        }
//
//        List<Integer> result = new ArrayList<>();
//        result.addAll(integers);
//        return result;
//    }

    /**
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {

        int num1 = 0;
        int num2 = 0;

        int count1 = 0;
        int count2 = 0;

        for (int num :
                nums) {
            if (num == num1){
                count1 ++;
            }else if (num == num2) {
                count2 ++;
            }else if (count1 == 0) {
                num1 = num;
                count1 ++;
            }else if (count2 == 0) {
                num2 = num;
                count2 ++;
            }else {
                count1 --;
                count2 --;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num :
                nums) {
            if (num == num1) {
                count1 ++;
            }else if (num == num2) {
                count2 ++;
            }

        }

        int length = nums.length / 3;

        List<Integer> result = new ArrayList<>();
        if (count1 > length) {
            result.add(num1);
        }
        if (count2 > length) {
            result.add(num2);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2,2,9,3,9,3,9,3,9,3,9,3,9,3,9,3,9};
        s.majorityElement(nums);
    }
}