package c064;


import java.util.HashMap;
import java.util.Map;

class Solution {
    private int grid[][];
    private int sumGrid[][];

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        this.grid = grid;
        this.sumGrid = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumGrid[i][j] = -1;
            }
        }

        return helper(row - 1, col - 1);
    }

    private int helper(int x, int y) {

        if (sumGrid[x][y] == -1) {
            if (x == 0 && y == 0) {
                sumGrid[x][y] = this.grid[x][y];
            } else if (x == 0) {
                sumGrid[x][y] = this.grid[x][y] + helper(x, y - 1);
            } else if (y == 0) {
                sumGrid[x][y] = this.grid[x][y] + helper(x - 1, y);
            } else {
                sumGrid[x][y] = this.grid[x][y] + Math.min(helper(x - 1, y), helper(x, y - 1));
            }

        }
        return sumGrid[x][y];
    }
}