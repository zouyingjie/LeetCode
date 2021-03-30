package old.c219;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int len = nums.length;

        // int index = len - k;

        for (int i = 0; i < len; i ++){
            int index = i + k;
            int j = i+1 ;
            for( ;j <= index && j < len; j ++){
                if (nums[i] == nums[j]) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{99,99};
        Solution s = new Solution();
        s.containsNearbyDuplicate(nums, 2);
    }
}