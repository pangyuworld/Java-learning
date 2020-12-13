package com.leetcode.p217;

/**
 * @author Pang
 * @date 2020/12/13
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        boolean[] targets = new boolean[nums.length];
        for (int num : nums) {
            if (targets[num]) {
                return true;
            }
            targets[num] = true;
        }
        return false;
    }
}