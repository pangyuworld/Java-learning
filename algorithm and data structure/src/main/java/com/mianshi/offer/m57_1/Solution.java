package com.mianshi.offer.m57_1;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m57_1
 * @description:
 * @date 2020/2/27 10:49
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        if (nums.length == 1) {
            return result;
        }
        result = new int[2];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] + nums[r] == target) {
                // 找到结果
                result[0] = nums[l];
                result[1] = nums[r];
                return result;
            } else if (nums[l] + nums[r] < target) {
                // 小于目标值
                l++;
            } else if (nums[l] + nums[r] > target) {
                // 大于目标值
                r--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{21, 44, 45, 54, 62, 73, 74, 74, 74, 81}, 128)));
    }
}