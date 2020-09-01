package com.leetcode.p1365;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1365
 * @description:
 * @date 2020/3/4 12:59
 */
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[105];
        for (int num : nums) {
            for (int i = num+1; i <= 100; i++) {
                result[i]++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]=result[nums[i]];
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));

    }
}