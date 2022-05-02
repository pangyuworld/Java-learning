package com.leetcode.p883;

/**
 * @author godspeed.zxy
 * @version : Solution, v0.1 2022-04-26 9:10 下午 godspeed.zxy Exp $
 */
class Solution {
    public int projectionArea(int[][] grid) {
        int result = 0;
        int[][] temp = new int[2][grid.length];
        int upSize = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    upSize++;
                    temp[0][i] = Math.max(temp[0][i], grid[i][j]);
                    temp[1][j] = Math.max(temp[1][j], grid[i][j]);
                }
            }
        }
        for (int[] ints : temp) {
            for (int anInt : ints) {
                result += anInt;
            }
        }
        return (result + upSize);
    }

    //public static void main(String[] args) {
    //    int[][] ints = new int[][]{{1,0},{0,2}};
    //    System.out.println(new Solution().projectionArea(ints));
    //}
}