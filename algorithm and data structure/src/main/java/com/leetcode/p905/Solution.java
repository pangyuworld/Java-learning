package com.leetcode.p905;

import java.util.Arrays;

/**
 * @author godspeed.zxy
 * @version : Solution, v0.1 2022-04-28 7:50 下午 godspeed.zxy Exp $
 */
public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] % 2 == 1) {
                // 奇数
                while (nums[j] % 2 == 1 && i < j) {
                    j--;
                }
                if (nums[j] % 2 == 1) {
                    continue;
                }
                // 找到第一个偶数
                int x = nums[j];
                nums[j] = nums[i];
                nums[i] = x;
            }
            i++;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Solution.class.getName());
    }
}