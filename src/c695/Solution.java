package c695;

public class Solution {
    private int[][] grid;
    private int row;
    private int column;
    private int maxCount = 0;
    private int currentCount = 0;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        if (row == 0) {
            return row;
        }
        this.column = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j);
                    maxCount = Math.max(currentCount, maxCount);
                    currentCount = 0;
                } else {
                    continue;
                }

            }
        }
        return maxCount;
    }


    private void dfs(int i, int j) {

        if (i >= row || j >= column | i < 0 | j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            currentCount += 1;
            grid[i][j] = '0';
            dfs(i + 1, j);
            dfs(i - 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        s.maxAreaOfIsland(grid);
    }
}
