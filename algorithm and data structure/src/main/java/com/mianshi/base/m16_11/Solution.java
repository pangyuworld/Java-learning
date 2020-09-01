package com.mianshi.base.m16_11;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.base.m16_11
 * @description:
 * @date 2020/3/19 22:39
 */
class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k < 1) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        int[] res = new int[k + 1];
        for (int i = 0; i <= k; i++) {
            res[i] = longer * i + shorter * (k - i);
        }
        return res;
    }


}