package com.mianshi.offer.m65;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m65
 * @description:
 * @date 2020/2/14 14:51
 */
class Solution {
    public int add(int a, int b) {
        int sum = a, c = 0;
        while (b != 0) {
            sum = a ^ b;
            c = (a & b) << 1;
            a = sum;
            b = c;
        }
        return sum;
    }
}