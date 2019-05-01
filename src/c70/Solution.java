package c70;

public class Solution {

    private int N = 0;
    private int result = 0;

    public int climbStairs(int n) {
        this.N = n;
        boolean isOdd = true;

        int maxTwo = 0;

        if (N % 2 == 0) {
            maxTwo = n / 2 -1;
            this.result = 2;
            isOdd = false;
        }else {
            maxTwo = (n - 1) / 2;
            this.result  = 1;
        }

        for (int i = 1; i <= maxTwo; i ++) {
            int steps = n - i * 2 + i;

            if (i == 1) {
                this.result += steps;
            }else if (i == maxTwo) {
                if (isOdd) {
                    this.result += steps;
                }else {
                    this.result += (steps*(steps-1)/2);
                }
            }else {
                this.result += (steps*(steps-1)/2);
            }

        }

        return this.result;

    }

//    public int climbStairs(int n) {
//        this.N = n;
//
//        this.climb(0, 1);
//        this.climb(0, 2);
//
//        return this.result;
//
//    }
//
//    private void climb(int steps, int step) {
//
//        steps = steps + step;
//        if (steps >= N) {
//            if (steps == N) {
//                this.result += 1;
//            }
//            return;
//        }
//        climb(steps, 1);
//        climb(steps, 2);
//    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int res = s.climbStairs(7);
        System.out.println(res);
    }
}
