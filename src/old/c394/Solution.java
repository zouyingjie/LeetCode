package old.c394;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {

        Stack<Character> stack = new Stack();
        StringBuilder builder = new StringBuilder();

        int strLen = s.length();
        int lastIndex = strLen - 1;

        for (int i = 0; i < strLen; i++) {
            char c = s.charAt(i);

            if (c != ']') {
                stack.push(c);
            } else {
                while (!stack.empty()) {
                    char pop = stack.pop();
                    if (pop == '[') {

                        char num = stack.pop();
                        StringBuilder times = new StringBuilder();

                        while (true) {
                            if (!(num >= '0' && num <= '9')) {
                                stack.push(num);
                                break;

                            }else {
                                times.append(num);
                            }
                            if (stack.empty()) {
                                break;
                            }
                            num = stack.pop();
                        }

                        builder = builder.reverse();
                        if (times.length() > 0) {
                            int repeatTimes = Integer.valueOf(times.reverse().toString());
                            String str = builder.toString();
                            for (int j = 0; j < repeatTimes - 1; j++) {
                                builder.append(str);
                            }
                        }

                        String repeatStr = builder.toString();
                        int len = repeatStr.length();
                        for (int j = 0; j < len; j++) {
                            stack.push(repeatStr.charAt(j));
                        }

                        if (i != lastIndex) {
                            builder = new StringBuilder();
                        }
                        break;
                    } else {
                        builder.append(pop);
                    }
                }
            }

        }

        return builder.reverse().toString();
    }

}