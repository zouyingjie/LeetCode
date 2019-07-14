package c004;

import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;

        int totalLen = len1 + len2;
        int[] nums = new int[totalLen];

        int index = 0;
        for (int i = 0; i < len1;i ++) {
            nums[index++] = nums1[i];
        }
        for (int i = 0; i < len2;i ++) {
            nums[index++] = nums2[i];
        }

        Arrays.sort(nums);
        int mediaIndex  = totalLen/2;

        if (totalLen % 2 == 0) {
            return ((double)(nums[mediaIndex]) + (double)(nums[mediaIndex-1])) / 2;
        }else {
            return (double)(nums[mediaIndex]);
        }
    }
}

