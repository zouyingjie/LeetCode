package c020;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        int length = s.length();

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);


            if (!this.isEqual(stack.peek(), c) || stack.empty() ) {
                stack.push(c);
            }else {
                stack.pop();
            }

        }

        return stack.empty();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
    }

    public boolean isEqual(char c1, char c2) {
        if ((c1 == '(' && c2 == ')')
                || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }
}