package c154;


class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int min = 0;
        int max = len - 1;

        if (nums[min] < nums[max]) {
            return nums[min];
        }

        while (min < max) {
            if (nums[min] == nums[max]) {
                min ++;
                max --;
            }else {
                break;
            }
        }

        if (min > max) {
            return nums[min];
        }

        int mid = (min + max) / 2;
        while (min < max) {
            if (nums[min] <  nums[mid]) {
                min = mid;
                mid = (min + max) / 2;
            }else if (nums[min] > nums[mid]){
                max = mid;
                mid = (min + max) / 2;
            }else {
                if (min > 0 && nums[min-1] > nums[min]) {
                    break;
                }else if (min < len -1 && nums[min] > nums[min+1]){
                    break;
                }

                while (min < len -1) {
                    if (nums[min] == nums[min + 1]) {
                        min ++;
                    }else {
                        mid = (min + max) / 2;
                        break;
                    }
                }

            }
        }

        if (min < len -1) {
            if (nums[min] > nums[min + 1]) {
                return nums[min + 1];
            }
        }
        return nums[min];
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,3,1};
        Solution s = new Solution();
        int min = s.findMin(nums);
        System.out.println(min);
    }
}