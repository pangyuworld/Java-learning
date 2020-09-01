package com.mianshi.offer.m42;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m42
 * @description:
 * @date 2020/4/3 13:26
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}