package old.c771;

class Solution {
    public int numJewelsInStones(String J, String S) {

        int num = 0;
        int length = S.length();

        for (int i = 0; i < length; i ++) {
            if (J.contains(String.valueOf(S.charAt(i)))) {
                num ++;
            }
        }

        return num;
    }
}