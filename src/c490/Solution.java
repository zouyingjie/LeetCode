package c490;

import java.util.ArrayList;
import java.util.List;

class Point {
    int row;
    int col;
    int value;
    int direct = 999;

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}


public class Solution {

    private static final int TOP = 0;
    private static final int RIGHT = 1;
    private static final int BOTTOM = 2;
    private static final int LEFT = 3;

    private int[][] maze;

    private List<Point> points = new ArrayList<>();

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

        boolean destCanShop = this.canStop(new Point(destination[0], destination[1]));
        if (!destCanShop) {
            return false;
        }

        this.dfs(new Point(start[0], start[1]));

        return this.result;

    }

    private void dfs(Point point) {
        if (point.row < 0 || point.row > maxRow || point.col < 0 || point.col > maxCol) {
            return;
        }
        if (point.value == 1) {
            return;
        }

        if (this.isDest(point)) {
            if (this.canStop(point)) {
                this.result = true;
            }
            return;
        }

        this.dfs(new Point(point.row-1, point.col));
        this.dfs(new Point(point.row+1, point.col));
        this.dfs(new Point(point.row, point.col - 1));
        this.dfs(new Point(point.row, point.col + 1));

    }

//    public void bfs() {
//
//
//        List<Point> ps = new ArrayList<>();
//
//        for (Point point : this.points) {
//            List<Point> currentPoints = new ArrayList<>();
//            if (point.row > 0 && point.direct != BOTTOM) {
//                Point top = new Point(point.row - 1, point.col, maze[point.row - 1][ point.col]);
//
//                if (top.value == 0) {
//                    top.direct = TOP;
//                    currentPoints.add(top);
//                }
//            }
//
//            if (point.col < this.maxCol && point.direct != LEFT) {
//                Point right = new Point(point.row, point.col + 1, maze[point.row][point.col + 1]);
//                if (right.value == 0) {
//                    right.direct = RIGHT;
//                    currentPoints.add(right);
//                }
//            }
//
//            if (point.row < this.maxRow  && point.direct != TOP) {
//                Point bottom = new Point(point.row + 1, point.col, maze[point.row + 1][ point.col]);
//                if (bottom.value == 0) {
//                    bottom.direct = BOTTOM;
//                    currentPoints.add(bottom);
//                }
//            }
//
//
//            if (point.col > 0 && point.direct != RIGHT) {
//                Point left = new Point(point.row, point.col - 1, maze[point.row][point.col - 1]);
//                if (left.value == 0) {
//                    left.direct = LEFT;
//                    currentPoints.add(left);
//                }
//            }
//
//
//            int size = currentPoints.size();
//
//            if (size == 0) {
//                continue;
//            }
//
//            for (int i = 0; i < size; i ++) {
//                Point p = currentPoints.get(i);
//                if (isDest(p)) {
//                    if (canStop(p)) {
//                        this.result = true;
//                        return;
//                    }else {
//                        this.result = false;
//                        return;
//                    }
//                }
//            }
//
//            ps.addAll(currentPoints);
//
//        }
//
//        if (ps.size() == 0) {
//            return;
//        }
//        this.points = ps;
//        this.bfs();
//
//
//    }

    public boolean isDest(Point point) {
        if (point.row == this.destRow && point.col == this.destCol) {
            return true;
        }
        return false;
    }

    public boolean canStop(Point point) {
        if (point.row == 0|| point.row == this.maxRow || point.col == 0 || point.col == this.maxCol) {
            return true;
        }

        if (this.maze[point.row-1][point.col] != this.maze[point.row+1][point.col] || this.maze[point.row][point.col-1] != this.maze[point.row][point.col+1]) {
            return true;
        }
        return false;
    }


//    public boolean canStop(Point point) {
//        switch (point.direct) {
//            case Solution.TOP:
//                if (point.row == 0) {
//                    return true;
//                }
//                break;
//            case Solution.RIGHT:
//                if (point.col == this.maxCol) {
//                    return true;
//                }
//                break;
//            case Solution.BOTTOM:
//                if (point.row == this.maxRow) {
//                    return true;
//                }
//                break;
//            case Solution.LEFT:
//                if (point.col == 0) {
//                    return true;
//                }
//                break;
//            default:
//                return false;
//
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[][] maze = new int[][] {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] dest = new int[]{4, 4};

        Solution s = new Solution();
        s.hasPath(maze, start, dest);
    }
}
