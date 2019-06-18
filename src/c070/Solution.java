package c070;

public class Solution {

//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        return climbStairs(n-1) + climbStairs(n-2);
//
//    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 3;
        }
        return climbStairs(n-3) + 2 * climbStairs(n-2);

    }




    public static void main(String[] args) {

        Solution s = new Solution();
        int res = s.climbStairs(3);
        System.out.println(res);
    }
}
