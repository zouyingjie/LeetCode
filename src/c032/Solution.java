package c032;

import java.util.Stack;

public class Solution {
    private int longestNum = 0;
    public int longestValidParentheses(String s) {

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int length = chars.length;
        boolean flag = false;
        int num = 0;
        for (int i = 0; i < length; i ++) {
            if (chars[i] == '(' && chars[i+1] == ')') {
                flag = true;
                num += 1;
            }else if (flag){
                continue;
            }else {
                longestNum = Math.max(num, longestNum);
                num = 0;
            }
        }

        return Math.max(num, longestNum) * 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestValidParentheses("(()");
    }
}
