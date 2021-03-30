package old.c067;

import java.util.Arrays;

public class Solution {
    public String addBinary(String a, String b) {

        int aLength = a.length();
        int bLength = b.length();

        if (aLength > bLength) {
           return add(a, b);
        }else {
            return add(b, a);
        }

    }

    private String add(String longger, String shorter) {
        char carryBit = '0';
        char[] longArr = longger.toCharArray();
        char[] shortArr = shorter.toCharArray();


        int longLen = longger.length();
        int shortLen = shorter.length();
        int i = longLen - 1, j = shortLen - 1;
        for (; i >= 0 && j >= 0; i --, j --) {

            char charI = longArr[i];
            char charJ = shortArr[j];

            int sum =  charI + charJ + carryBit;
            if (sum >= 98) {
                longArr[i] = '1';
                carryBit = '1';
            }else {
                longArr[i] = (char) sum;
                carryBit = '0';
            }

        }

        while (i > 0 || carryBit > 0) {

            if (i < 0) {
                return carryBit + Arrays.toString(longArr);
            }
            int sum = longArr[i] + carryBit;
            if (sum >= 98) {
                longArr[i] = '1';
                i --;
                carryBit = '1';
            }else {
                longArr[i] = (char) sum;
                break;
            }
        }

        return Arrays.toString(longArr);
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String str = s.addBinary("11", "1");
        System.out.println(str);
    }
}
