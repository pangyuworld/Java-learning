package com.leetcode.p693;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p693
 * @description:
 * @date 2020/3/19 23:19
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & (n + 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hasAlternatingBits(4));
    }
}