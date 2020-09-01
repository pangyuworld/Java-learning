package com.leetcode.p1005;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1005
 * @description:
 * @date 2020/3/19 21:50
 */
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int[] num = new int[201];
        int sum = 0;
        for (int i : A) {
            num[i + 100]++;
            sum += i;
        }
        int i = 0;
        while (K > 0) {
            while (num[i] <= 0) i++;
            sum -= (i - 100) * 2;
            num[i]--;
            num[200 - i]++;
            if (i > 100) i = 200 - i;
            K--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestSumAfterKNegations(new int[]{-2, 9, 9, 8, 4}, 3));
    }
}