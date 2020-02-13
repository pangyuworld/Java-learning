package com.leecode.p53;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p53
 * @description:
 * @date 2020/2/11 13:12
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] maxArray = new int[nums.length];
        int maxValue = nums[0];
        maxArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxArray[i - 1] > 0) {
                // 如果之前记录的最大值大于0，那么就继续加上现在的值
                maxArray[i] = maxArray[i - 1] + nums[i];
            } else {
                maxArray[i] = nums[i];
            }
            if (maxValue < maxArray[i]) {
                maxValue = maxArray[i];
            }

        }
        return maxValue;
    }
}