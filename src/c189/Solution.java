package c189;

import java.util.Arrays;

class Solution {
    /***
     * 0, len - k- 1
     * len -k ,len -1
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int roratePoint = 0;
        if (k > length) {
            roratePoint = 0;
        }else {
            roratePoint = length - k;
        }
        int[] nums1 = Arrays.copyOfRange(nums, 0, roratePoint);
        int[] nums2 = Arrays.copyOfRange(nums, roratePoint, length);

        for (int i = 0; i < nums1.length; i ++) {
            nums[k+i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i ++) {
           nums[i] = nums2[i];
        }

        for (int i = 0; i < nums.length; i ++) {
            System.out.println(nums[i]);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2};

        s.rotate(nums, 3);
    }
}