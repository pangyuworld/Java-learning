package com.mianshi.offer.m62;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m62
 * @description:
 * @date 2020/2/14 11:21
 */
class Solution {
    public int lastRemaining(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining((n - 1), m) + m) % n;
    }
}