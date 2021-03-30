package old.c914;

import java.util.*;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int length = deck.length;
        Arrays.sort(deck);

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 1; i < length; i ++) {
            int val = map.getOrDefault(deck[i], 0) + 1;
            map.put(deck[i], val);

        }


        int num = map.get(deck[0]);

        for(Integer value: map.values()) {
            if (value % num != 0) {
                return false;
            }
        }
        return true;
    }
}
