package old.c739;

import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {

//        List<Integer> list = new ArrayList<>();
////
////        int length = T.length;
////
////        for (int i = 0; i < length - 1; i ++) {
////            int days = 0;
////            for (int j = i + 1; j < length; j ++) {
////                days ++;
////                if (T[j] > T[i]) {
////                    list.add(days);
////                    break;
////                }else if (j == length -1) {
////                    list.add(0);
////                }
////            }
////        }
////
////        int size = list.size() ;
////        int[] result = new int[size+1];
////        for (int i = 0; i < size; i ++) {
////            result[i] = list.get(i);
////        }
////        result[size] = 0;
////
////        return result;

//        int length = T.length;
//        int[] result = new int[length];
//        for (int i = 0; i < length - 1; i ++) {
//            int days = 0;
//            for (int j = i + 1; j < length; j ++) {
//                days ++;
//                if (T[j] > T[i]) {
//                    result[i] = days;
//                    break;
//                }else if (j == length -1) {
//                    result[i] = 0;
//                }
//            }
//        }
//        result[length-1] = 0;
//        return result;

        /**
         * 栈的实现
         *
         * 将索引入栈
         *
         * 每次遍历，查看其比栈中的哪些值大，如果大于栈中索引对应的值，则将该索引出栈，然后计算差值
         *
         */
        Stack<Integer> stack = new Stack();

        int length = T.length;

        int[] result = new int[length];

        for (int i = 0; i < length; i ++) {

            while (!stack.empty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;

    }
}