package com.leetcode.p1137;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1137
 * @description:
 * @date 2020/3/19 22:28
 */
class Solution {
    public int tribonacci(int n) {
        int n0 = 0;
        int n1 = 1;
        int n2 = 1;
        int nn = 0;
        switch (n) {
            case 0:
                nn = 0;
                break;
            case 1:
                nn = 1;
                break;
            case 2:
                nn = 1;
                break;
            default:
                for (int i = 3; i <= n; i++) {
                    nn = n0 + n1 + n2;
                    n0 = n1;
                    n1 = n2;
                    n2 = nn;
                }
        }
        return nn;
    }
}