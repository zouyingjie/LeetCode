package old.c278;

public class Solution {
    public int firstBadVersion(int n) {

        if (isBadVersion(1)) {
            return 1;
        }

        long min = 1;
        long max = n;

        long mid = (max + min) / 2;

        while (min <= max) {
            if (isBadVersion((int) mid)) {
                if (isBadVersion((int) (mid - 1))) {
                    max = mid - 1;
                    mid = (max + min) / 2;
                }else {
                    return (int) mid;
                }
            }else {

                min = mid + 1;
                if (isBadVersion((int) min)) {
                    return (int) min;
                }
                mid = (max + min) / 2;
            }
        }
        return n;
    }

    private boolean isBadVersion(int version) {

        if(version >= 1702766719){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.firstBadVersion(2126753390);
    }
}
