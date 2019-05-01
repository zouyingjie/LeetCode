package c961;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int repeatedNTimes(int[] A) {

//        Map<Integer, Integer> map = new HashMap<>();

        HashSet<Integer> set = new HashSet<>();
        int len = A.length;

        for (int i = 0; i < len; i++) {
            if (set.contains(A[i])) {
                return A[i];
            }
            set.add(A[i]);
        }
        return 0;
    }
}
