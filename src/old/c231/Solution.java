package old.c231;

public class Solution {

    public boolean isPowerOfTwo(int n) {

        while (n != 1) {
            if (n % 2 == 1) {
                return false;
            }

            n = n / 2;
        }
        return true;
    }
}
