package com.leetcode.p486;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/1 9:22 godspeed.zxy Exp $
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().PredictTheWinner(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }

    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        if (length % 2 == 0) {
            return true;
        }
        int[][] dp = new int[length][length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }
}