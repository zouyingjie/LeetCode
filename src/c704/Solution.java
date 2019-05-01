package c704;

public class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;

        int min = 0;
        int max = length - 1;
        int mid = (min + max) / 2;

        while (min <= max) {
            if (nums[mid] == target) {
                return mid;
            }else if (nums[mid] > target) {
                max = mid - 1;
                mid = (min + max) / 2;
            }else {
                min = mid + 1;
                mid = (min + max) / 2;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.search(new int[]{-1,0,3,5,9,12}, 2);
    }
}
