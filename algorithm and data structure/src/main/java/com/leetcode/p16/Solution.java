package com.leetcode.p16;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p16
 * @description:
 * @date 2020/2/9 12:00
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (result == Integer.MAX_VALUE) result = sum;
                if (Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                }
                if (sum > target) r--;
                else if (sum < target) l++;
                else return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1);
    }
}
