package com.leetcode.p461;

import java.util.Arrays;

/**
 * @author Pang
 * @date 2021/2/16
 */
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += Math.min(nums[i],nums[i+1]);
        }
        return sum;
    }
}