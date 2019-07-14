package c062;

import java.util.HashMap;
import java.util.Map;

class Solution {

    private int grid[][];


    public int uniquePaths(int m, int n) {

        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        this.grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                this.grid[i][j] = 0;
            }
        }
        return helper(n - 2, m-1) + helper(n-1, m - 2);
    }

    private int helper(int x, int y) {

        if (x == 0 && y == 0) {
            return 1;
        }

        if (x < 0 || y < 0) {
            return 0;
        }

        if (grid[x][y] == 0) {
            int sum = helper(x - 1, y) + helper(x, y - 1);
            grid[x][y] = sum;
        }
        return grid[x][y];
    }
}