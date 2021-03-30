package old.c063;

class Solution {
    private int[][] obstacleGrid;
    private int[][] grid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        this.obstacleGrid = obstacleGrid;

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        this.grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                this.grid[i][j] = 0;
            }
        }
        return helper(row - 1, col -1);
    }

    private int helper(int x, int y) {

        if ((x < 0 || y < 0) || (this.obstacleGrid[x][y] == 1)) {
            return 0;
        }

        if (x == 0 && y == 0) {
            return 1;
        }

        if (grid[x][y] == 0) {
            int sum = helper(x - 1, y) + helper(x, y - 1);
            grid[x][y] = sum;
        }
        return grid[x][y];
    }
}