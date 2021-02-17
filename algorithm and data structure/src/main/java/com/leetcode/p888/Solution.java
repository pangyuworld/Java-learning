package com.leetcode.p888;

import java.util.Arrays;

/**
 * @author Pang
 * @date 2021/2/15
 */
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        /*
            设x为A中某数，y为B中某数，则：
            A-x+y = B+x-y
            解得 y = x + (B-A)/2
            解得 x = y - (B-A)/2
         */
        int sumA = 0, sumB = 0;
        for (int i : A) {
            sumA += i;
        }
        for (int i : B) {
            sumB += i;
        }
        int diff = sumB - sumA;
        // num数组为一个占位数组，为true的地方表示有答案出现
        boolean[] num = new boolean[100001];
        for (int x : A) {
            int y = diff / 2 + x;
            if (y < 0 || y > 100000) continue;
            num[y] = true;
        }
        for (int y : B) {
            if (num[y]) {
                return new int[]{y - diff / 2, y};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4})));
    }
}