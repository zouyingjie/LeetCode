package c202;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {


    ConcurrentHashMap map = new ConcurrentHashMap();
    CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    public boolean isHappy(int n) {

        if (n <= 0) {
            return false;
        }
        while (n > 10) {
            n = sum(n);
        }

        if (n == 1) {
            return true;
        }

        return false;

    }

    private int sum(int n) {

        int result = 0;
        while (n >= 10) {
            result += Math.pow(n % 10, 2);
            n = n / 10;
        }

        result += Math.pow(n % 10, 2);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isHappy(19);
    }
}
