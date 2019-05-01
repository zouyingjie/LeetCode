package c200;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Solution {

    private int result = 0;
    private char[][] grid = null;
    private int row = 0;
    private int column = 0;


    public int numIslands(char[][] grid) {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.size();
        map.put("a", "b");
        map.get("a");
        this.grid = grid;
        this.row = grid.length;
        if (row == 0) {
            return row;
        }
        this.column = grid[0].length;

        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j ++) {
                if (grid[i][j] == '1') {
                    result ++;
                    dfs(i, j);
                }else {
                    continue;
                }

            }
        }
        return result;
    }

    private void dfs(int i, int j) {

        if (i >= row || j >= column | i < 0 | j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(i +1, j);
            dfs(i -1, j);
            dfs(i , j+1);
            dfs(i , j-1);
        }


    }

    public static void main(String[] args) {

//        Solution s = new Solution();
//        char[][] grid = new char[][]{
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'},
//        };
//
//        int i = s.numIslands(grid);
//        System.out.println(i);

        int concurrencyLevel = 16;
        int sshift = 0;
        int ssize = 1;

        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
        }
        System.out.println(ssize);
    }

    private int value;
    private ReentrantLock lock = new ReentrantLock();

    public synchronized int get() {
        return value;
    }

    public synchronized void addOne() {
        value += 1;
    }

    public void addValue(int value) {
        ReentrantLock lock = this.lock;
        lock.lock();
        this.value += value;
        lock.unlock();

    }
}
