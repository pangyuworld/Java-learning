package com.leetcode.p1124;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1124
 * @description:
 * @date 2020/3/19 21:36
 */
class Solution {
    public int longestWPI(int[] hours) {
        if (hours.length < 1) return 0;
        int max = 0, temp = 0;
        for (int hour : hours) {
            if (hour > 8) {
                temp++;
                max = Math.max(temp, max);
            } else {
                temp--;
                if (temp < 0) {
                    temp = 0;
                }
            }
        }
        return max;
    }
}