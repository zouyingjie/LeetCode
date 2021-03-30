package old.c007;


class Solution {
    public int reverse(int x) {

        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }

        while (x % 10 == 0) {
            x = x / 10;
        }

        StringBuffer str = new StringBuffer(String.valueOf(x));
        StringBuffer reverseStr = str.reverse();
        int result = Integer.valueOf(reverseStr.toString());
        if (isNegative) {
            result = -result;
        }
        return result;
    }
}