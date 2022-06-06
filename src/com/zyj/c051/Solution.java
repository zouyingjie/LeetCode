package com.zyj.c051;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {

    }

}

class BackUp {
    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    Long nodeId;
    Long hostId;
}

class Solution01 {
    private List<List<String>> result = new ArrayList<>();
    private int N;

    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        processQueue(new ArrayList<>(), 0);
        return result;
    }

    private void processQueue(List<String> queue, int row) {
        if (row == N) {
            result.add(queue);
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
        // Same column
        for (int i = row - 1; i >= 0; i--) {
            if (queues.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        // Left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (queues.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Right diagonal
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

class Solution2 {

    int N = 0;
    int[][] queuePositions;
    public List<List<String>> solveNQueens(int n) {
        this.N = n;
        queuePositions = new int[N][N];
//        this.processQueue(queuePositions, 0);


        List<List<String>> res = new ArrayList<>();
        return res;
//
//        for (List<Integer> positions: queuePositions) {
//            for (Integer position: positions) {
//                List<String> s = new ArrayList<>(N);
//                for (int i = 0; i < N; i ++) {
//                    if (i == position) {
//                        s.set(i, "Q");
//                    }else {
//                        s.set(i, ".");
//                    }
//                }
//
//            }
//        }
    }

    private void processQueue(int[] queue, Integer row) {
        if (row == this.N) {
            return;
        }
        for (int col = 0; col < N; col ++) {
            if (canPlace(queue, row, col)) {
                queue[row] = col;
                processQueue(queue, row + 1);
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
