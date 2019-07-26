package c202;

import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Solution {

    private HashMap<Integer, Integer> map = new HashMap<>();
    public boolean isHappy(int n) {

        if (n <= 0) {
            return false;
        }

        while (n > 0) {
            if (n == 1) {
                return true;
            }
            map.put(n, n);
            n = helper(n);
            if (map.containsKey(n)) {
                return false;
            }
        }

        return false;
    }

    private int helper(int n) {
        int sum = 0;
        while (n >= 10) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        sum += Math.pow(n % 10, 2);
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(19));
    }
}
