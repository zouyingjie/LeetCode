package c490;


public class Solution {

    private static final int TOP = 0;
    private static final int RIGHT = 1;
    private static final int BOTTOM = 2;
    private static final int LEFT = 3;

    private int[][] maze;


    private int maxRow, maxCol;

    private int destRow = 0;
    private int destCol = 0;

    private boolean result = false;



    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        this.maze = maze;
        this.maxRow = maze.length - 1;
        this.maxCol = maze[0].length - 1;

        this.destRow = destination[0];
        this.destCol = destination[1];


        this.dfs(start[0]-1, start[1], Solution.TOP);
        this.dfs(start[0]+1, start[1], Solution.BOTTOM);
        this.dfs(start[0], start[1] + 1, Solution.RIGHT);
        this.dfs(start[0], start[1] - 1, Solution.LEFT);

        return this.result;

    }

    private void dfs(int row, int col, int direct) {
        if (row < 0 || row > maxRow || col < 0 || col > maxCol) {
            return;
        }
        if (maze[row][col] == 1 || maze[row][col] == 2) {
            return;
        }

        if (this.isDest(row, col)) {
            if (this.canStop(row, col, direct)) {
                this.result = true;
            }
        }


        if (direct == Solution.TOP) {
            if (row == 0 || maze[row-1][col]==1) {
                this.dfs(row, col - 1, Solution.LEFT);
                this.dfs(row, col + 1, Solution.RIGHT);
            }
        }

        if (direct == Solution.BOTTOM) {
            if (row == maxRow || maze[row+1][col]==1) {
                this.dfs(row, col - 1, Solution.LEFT);
                this.dfs(row, col + 1, Solution.RIGHT);
            }
        }

        if (direct == Solution.LEFT) {
            if (col == 0 || maze[row][col-1]==1) {
                this.dfs(row-1, col, Solution.TOP);
                this.dfs(row+1, col, Solution.BOTTOM);
            }
        }

        if (direct == Solution.RIGHT) {
            if (col == maxCol || maze[row][col+1]==1) {
                this.dfs(row-1, col, Solution.TOP);
                this.dfs(row+1, col, Solution.BOTTOM);
            }
        }

    }


    public boolean isDest(int row, int col) {
        if (row == this.destRow && col == this.destCol) {
            return true;
        }
        return false;
    }

    public boolean canStop(int row, int col, int direct) {
        switch (direct) {
            case Solution.TOP:
                if (row == 0 || maze[row-1][col] == 1) {
                    return true;
                }
                break;
            case Solution.RIGHT:
                if (col == this.maxCol || maze[row][col+1] == 1) {
                    return true;
                }
                break;
            case Solution.BOTTOM:
                if (row == this.maxRow || maze[row+1][col] == 1) {
                    return true;
                }
                break;
            case Solution.LEFT:
                if (col == 0 || maze[row][col-1] == 1) {
                    return true;
                }
                break;
            default:
                return false;

        }
        return false;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        int[][] maze = new int[][]{{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] dest = new int[]{3, 2};
        s.hasPath(maze, start, dest);
    }
}
