package com.zyj.c052;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {


}


// 采用 ArrayList 模拟棋盘
class Solution01 {
    private int result = 0;
    private int N;

    public int totalNQueens(int n) {
        this.N = n;
        processQueue(new ArrayList<>(), 0);
        return result;
    }


    private void processQueue(List<String> queue, int row) {
        if (row == N) {
            this.result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            List<String> rowStr = initRow();
            if (canPlace(queue, row, col)) {
                rowStr.set(col, "Q");
                String s = convertToString(rowStr);
                List<String> newQueue = new ArrayList<>();
                newQueue.addAll(queue);
                newQueue.add(s);
                processQueue(newQueue, row + 1);
            }
        }
    }

    private boolean canPlace(List<String> queues, int row, int col) {
        if (queues.size() == 0) {
            return true;
        }
        for (int i = row - 1; i >= 0; i--) {
            if (queues.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (queues.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (queues.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> initRow() {
        List<String> l = new ArrayList<>();
        for (int j = 0; j < N; j++) {
            l.add(".");
        }
        return l;
    }

    private String convertToString(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String s : list) {
            builder.append(s);
        }
        return builder.toString();
    }
}


// 优化1：用数组索引表示行，值表示列，优化性能
class Solution2 {

    private int result = 0;
    private int N;

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.totalNQueens(4);
        System.out.println(i);
    }

    public int totalNQueens(int n) {
        this.N = n;
        int[] queue = new int[n];
        for (int i = 0; i < N; i++) {
            queue[i] = -1;
        }
        this.processQueue(queue, 0);
        return this.result;

    }

    private void processQueue(int[] queue, Integer row) {
        if (row == this.N) {
            this.result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (canPlace(queue, row, col)) {
                queue[row] = col;
                processQueue(queue, row + 1);
            } else {
                continue;
            }
            queue[row] = -1;
        }
    }

    private boolean canPlace(int[] queue, Integer row, Integer col) {
        for (int r = 0; r < row; r++) {
            if (queue[r] == col || queue[r] == col + row - r || queue[r] == col - row + r) {
                return false;
            }
        }
        return true;
    }
}

// 优化2：空间换时间，用两个 boolean 数组记录已有的放置情况
class Solution3 {

    int count = 0;
    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n];   // diagonals \
        boolean[] d2 = new boolean[2 * n];   // diagonals /
        backtracking(0, cols, d1, d2, n);
        return count;
    }

    public void backtracking(int row, boolean[] cols, boolean[] d1, boolean []d2, int n) {
        if(row == n) count++;

        for(int col = 0; col < n; col++) {
            int id1 = col - row + n;
            int id2 = col + row;
            if(cols[col] || d1[id1] || d2[id2]) continue;

            cols[col] = true; d1[id1] = true; d2[id2] = true;
            backtracking(row + 1, cols, d1, d2, n);
            cols[col] = false; d1[id1] = false; d2[id2] = false;
        }
    }

}

