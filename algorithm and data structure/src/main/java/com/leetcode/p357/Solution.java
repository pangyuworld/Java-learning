package com.leetcode.p357;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p357
 * @description:
 * @date 2020/4/4 9:43
 */
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int[] dp = new int[n + 1];
        dp[1] = 10;
        dp[2] = 9 * 9;
        int sum = dp[1] + dp[2];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] * (10 - i + 1);
            sum += dp[i];
        }
        return sum;
    }
}