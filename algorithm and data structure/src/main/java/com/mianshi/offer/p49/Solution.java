package com.mianshi.offer.p49;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.p49
 * @description:
 * @date 2020/2/14 15:00
 */
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        int p1 = 0, p2 = 0, p3 = 0;
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[p1] * 2, Math.min(dp[p3] * 5, dp[p2] * 3));
            if (dp[i] == dp[p1] * 2) p1++;
            if (dp[i] == dp[p2] * 3) p2++;
            if (dp[i] == dp[p3] * 5) p3++;
        }
        return dp[n - 1];
    }
}