package com.mianshi.offer.p47;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.p47
 * @description:
 * @date 2020/2/27 0:41
 */
class Solution {
    public int maxValue(int[][] grid) {
        if (grid.length < 1) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        // dp[m][n]=Math.max(dp[m-1][n],dp[m][n-1])+dp[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxValue(new int[][]{
                new int[]{1, 3, 1},
                new int[]{1, 5, 1},
                new int[]{4, 2, 1}
        }));
    }
}