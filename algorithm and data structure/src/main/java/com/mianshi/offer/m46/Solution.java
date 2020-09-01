package com.mianshi.offer.m46;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m46
 * @description:
 * @date 2020/2/27 1:03
 */
class Solution {

    public int translateNum(int num) {
        if (num < 10) return 1;
        char[] array = String.valueOf(num).toCharArray();
        int[] dp = new int[array.length];
        dp[0] = 1;
        if ((array[0] - '0') * 10 + array[1] - '0' < 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < array.length; i++) {
            if ((array[i - 1] - '0') * 10 + array[i] - '0' < 26 && array[i - 1] != '0') {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[array.length - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(25));
    }
}