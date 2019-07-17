package c242;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isAnagram(String s, String t) {


        if (s.length() != t.length()) {
            return false;
        }

        int len = s.length();


        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < len; i ++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        Set<Map.Entry<Character, Integer>> entries = sMap.entrySet();

        for (Map.Entry<Character, Integer> entry: entries) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (tMap.getOrDefault(key, 0) != value) {
                return false;
            }
        }
        return true;

    }
}