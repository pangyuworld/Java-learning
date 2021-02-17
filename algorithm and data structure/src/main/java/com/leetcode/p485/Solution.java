package com.leetcode.p485;

/**
 * @author Pang
 * @date 2021/2/15
 */
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int m1 = 0, m2 = 0;
        for (int num : nums) {
            if (num == 1) {
                m1++;
                if (m1 > m2) {
                    m2 = m1;
                }
            } else {
                m1 = 0;
            }
        }
        return m2;
    }
}