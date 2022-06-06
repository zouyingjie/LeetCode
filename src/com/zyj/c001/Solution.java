package com.zyj.c001;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}

// 方案 1： 暴力循环
class Solution01 {
    public int[] twoSum(int[] nums, int target) {

        int len = nums.length;
        for (int i = 0; i < len - 1; i ++) {
            for (int j = i + 1; j < len; j ++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;

    }
}

// 方案 2： 空间换时间

class Solution02 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{i, map.get(key)};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;

    }
}


// 方案3：《Algorithms》 中提到的二分查找，不过这里索引已经变了，不适用与题目
class Solution03 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        Solution03 s = new Solution03();
        int[] ints = s.twoSum(nums, 6);
        for (int i = 0; i < ints.length; i ++) {
            System.out.println(ints[i]);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            int index = BinarySearch.indexOf(nums, target - nums[i]);
            if (index != -1) {
                return new int[]{i, index};
            }
        }
        return null;

    }
}


