package c905;


class Solution {
    public int[] sortArrayByParity(int[] A) {

        int len = A.length;

        int currentLastIndex = len - 1;
        int currentPreIndex = 0;

        int[] result = new int[len];

        for (int i = 0; i < len; i ++) {
            int num = A[i];
            if (isEven(A[i])) {
                result[currentPreIndex++] = A[i];
            }else {
                result[currentLastIndex--] = A[i];
            }
        }
        return result;
    }

    private boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}