package com.mianshi.offer.m64;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m64
 * @description:
 * @date 2020/2/14 10:29
 */
class Solution {
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n > 0 && (sum += sumNums(n - 1))>0;
        return sum;
    }
}