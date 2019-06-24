package c003;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int len = s.length();
        int maxLength = 0;

        for (int i = 0; i < len; i++) {

            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int lastIndex = map.get(c);
                if (lastIndex >= start) {
                    start = lastIndex + 1;
                }
            }

            int currentLength = i - start + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
            }

            map.put(c, i);
        }

        return maxLength;
    }
}
