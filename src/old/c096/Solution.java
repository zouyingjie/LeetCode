package old.c096;

class Solution {

    public int numTrees(int n) {

        // G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)

        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        for (int i =2; i <= n; i ++) {

            for (int j = 0; j < i; j ++) {
                G[i] += G[j] * G[i-j-1];
            }

        }

        return G[n];
    }

//    public long numTrees(long n) {
//
//        if (n == 1) {
//            return 1;
//        }  else {
//            return numTrees(n - 1) * 2 * (2 * n - 1) / (n + 1);
//        }
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(19));
    }
}