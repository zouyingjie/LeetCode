package old.c992;

class Solution {
    public int[] sortArrayByParityII(int[] A) {

            int len = A.length;

            int evenIndex = 0;
            int oddIndex = 1;


            int[] result = new int[len];

            for (int i = 0; i < len; i ++) {
                int num = A[i];
                if (num % 2 == 0) {
                    result[evenIndex] = num;
                    evenIndex += 2;
                }else {
                    result[oddIndex] = num;
                    oddIndex += 2;
                }
            }
            return result;
        }

}