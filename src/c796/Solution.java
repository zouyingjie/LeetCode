package c796;

class Solution {
    public boolean rotateString(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() == 0) {
            return true;
        }

        int length = A.length();

        for (int i = 0; i < length; i ++) {
            if ((A.substring(0, (length - i)).equals(B.substring(i, length))) &&
                    (A.substring(length - i, length).equals(B.substring(0, i)))) {
                return true;
            }
        }

        return false;
    }

}
