package com.leetcode.p391;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p391
 * @description:
 * @date 2020/4/4 10:54
 */
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return true;
        Set<Point> pointMap = new HashSet<>();
        int maxRow = 0, maxCow = 0;
        for (int[] rectangle : rectangles) {
            maxCow = Math.max(maxCow, rectangle[2]);
            maxRow = Math.max(maxRow, rectangle[3]);
            for (int i = rectangle[0]; i < rectangle[2]; i++) {
                for (int j = rectangle[1]; j < rectangle[3]; j++) {
                    Point point = new Point(i, j);
                    if (pointMap.contains(point)) return false;
                    pointMap.add(point);
                }
            }
        }
        int[][] seq = new int[maxCow + 1][maxRow + 1];
        for (Point point : pointMap) {
            seq[point.x][point.y] = 1;
        }
        int startTop = 0, startLeft = 0;
        int endDown = seq.length - 1, endRight = seq[0].length - 1;
        boolean flag = false;
        for (int i = startTop; i < endDown; i++) {
            for (int j = startLeft; j < endRight; j++) {
                if (!flag && seq[i][j] > 0) {
                    // 第一次发现大于0的
                    startTop = i;
                    startLeft = j;
                    flag = true;
                }
                if (flag && seq[i][j] < 1) {
                    return false;
                }
            }
        }
        return true;
    }

    class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isRectangleCover(
// [[0,0,4,1],[7,0,8,2],[6,2,8,3],[5,1,6,3],[4,0,5,1],[6,0,7,2],[4,2,5,3],[2,1,4,3],[0,1,2,2],[0,2,2,3],[4,1,5,2],[5,0,6,1]]
                new int[][]{
                        new int[]{0, 0, 4, 1},
                        new int[]{7, 0, 8, 2},
                        new int[]{6, 2, 8, 3},
                        new int[]{5, 1, 6, 3},
                        new int[]{4, 0, 5, 1},
                        new int[]{6, 0, 7, 2},
                        new int[]{4, 2, 5, 3},
                        new int[]{2, 1, 4, 3},
                        new int[]{0, 1, 2, 2},
                        new int[]{0, 2, 2, 2},
                        new int[]{4, 1, 5, 2},
                        new int[]{5, 0, 6, 1}
                }
        ));
    }
}