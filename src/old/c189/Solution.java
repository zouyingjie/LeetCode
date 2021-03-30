package old.c189;

class Solution {
    /***
     * 0, len - k- 1
     * len -k ,len -1
     * @param nums
     * @param k
     */

    private int len = 0;
    public void rotate(int[] nums, int k) {
        this.len = nums.length;
        k = k % len;

        reverse(nums, 0, len - 1);
        reverse(nums,0, k-1);
        reverse(nums,k, len - 1);
    }


    public void reverse(int[] nums, int start, int end) {

        while (start <= end) {
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;

            start ++;
            end --;
        }
    }
}