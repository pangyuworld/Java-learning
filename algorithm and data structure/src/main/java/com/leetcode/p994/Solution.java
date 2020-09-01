package com.leetcode.p994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p994
 * @description:
 * @date 2020/3/4 10:22
 */
class Solution {
    class Point {
        int x, y;
        int min;

        public Point(int x, int y, int min) {
            this.x = x;
            this.y = y;
            this.min = min;
        }
    }

    public int orangesRotting(int[][] grid) {

        int result = 0;
        Queue<Point> pointQueue = new LinkedList<>();
        // 首先将所有1的点添加入队
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    pointQueue.add(new Point(i, j, 0));
                }
            }
        }
        while (!pointQueue.isEmpty()) {
            Point point = pointQueue.poll();
            result = Math.max(result, point.min);
            // 左
            if (point.y - 1 >= 0 && grid[point.x][point.y - 1] == 1) {
                grid[point.x][point.y - 1] = 2;
                pointQueue.add(new Point(point.x, point.y - 1, point.min + 1));
            }
            // 上
            if (point.x - 1 >= 0 && grid[point.x - 1][point.y] == 1) {
                grid[point.x - 1][point.y] = 2;
                pointQueue.add(new Point(point.x - 1, point.y, point.min + 1));
            }
            // 下
            if (point.x + 1 < grid.length && grid[point.x + 1][point.y] == 1) {
                grid[point.x + 1][point.y] = 2;
                pointQueue.add(new Point(point.x + 1, point.y, point.min + 1));
            }
            // 右
            if (point.y + 1 < grid[0].length && grid[point.x][point.y + 1] == 1) {
                grid[point.x][point.y + 1] = 2;
                pointQueue.add(new Point(point.x, point.y + 1, point.min + 1));
            }
        }
        // 最后检查有没有剩余节点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // [[2,1,1],[1,1,0],[0,1,1]]
        System.out.println(new Solution().orangesRotting(new int[][]{
                new int[]{2, 1, 1},
                new int[]{1, 1, 0},
                new int[]{0, 1, 1}}));
    }
}