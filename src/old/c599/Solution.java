package old.c599;

import java.util.*;

/**
 * 遍历记录重复次数
 *
 * 想多的几点:
 * 其实没必要计较长度
 * 多个相等出现次数的情况，主要出现 sum 更小的则直接相加即可
 *
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int length = list1.length;
        for (int i = 0; i < length; i++) {
            map.put(list1[i], i);
        }

        int l2Length = list2.length;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < l2Length; i ++) {
            String s = list2[i];
            Integer j = map.get(s);

            if (j != null && i + j <= minSum) {
                int sum = i + j;
                if (sum < minSum) {
                    result.clear();
                    minSum = sum;
                }
                result.add(s);
            }
        }
        return result.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] s2 = new String[]{ "KFC","Shogun","Burger King"};

        Solution s = new Solution();
        s.findRestaurant(s1, s2);
    }
}
