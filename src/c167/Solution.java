package c167;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lenght = numbers.length;
        for (int i = 0; i < lenght -1 ; i ++) {
            int j = i + 1;
            while (j < lenght) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }else if (numbers[i] + numbers[j] > target) {
                    break;
                }else {
                    j ++;
                }
            }
        }
        return new int[]{};
    }
}
