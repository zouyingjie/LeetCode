package old.c039;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {



    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        int len = candidates.length;

        for (int i = 0; i < len; i ++) {
            map.put(candidates[i], i);
        }

        for (int i = 0; i < len; i ++) {
            int num = candidates[i];
            int mod = target % num;
            if (mod == 0) {
                int quotient = target / num;
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < quotient; j ++) {
                    list.add(num);
                }
                result.add(list);
            }else if (map.containsKey(mod)){
                int quotient = target / num;
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < quotient; j ++) {
                    list.add(num);
                }
                list.add(mod);
                result.add(list);
            }
        }

        return result;

    }
}
