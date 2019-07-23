package c859;

class Solution {
    public boolean buddyStrings(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();

        if(lenA != lenB) {
            return false;
        }



        boolean hasSwap = false;
        for(int i = 0; i < lenA -1; i ++) {


            if(A.charAt(i) == B.charAt(i)) {
                continue;
            }

            if(A.charAt(i+1) == B.charAt(i) && A.charAt(i) == B.charAt(i+1)) {
                if(hasSwap) {
                    return false;
                }else {
                    hasSwap = true;
                    continue;
                }
            }
        }

        if (!hasSwap) {
            return A.equals(B);
        }
        return hasSwap;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String A = "ab";
        String B = "ab";
        System.out.println(s.buddyStrings(A, B));
    }
}