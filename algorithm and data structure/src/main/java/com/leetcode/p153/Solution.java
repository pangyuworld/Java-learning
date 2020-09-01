package com.leetcode.p153;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p153
 * @description:
 * @date 2020/3/19 21:18
 */
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int right = nums[nums.length - 1];
        int rightIndex = nums.length - 1;
        int leftIndex = 0;
        int mid = 0;
        while (leftIndex < rightIndex) {
            mid = (rightIndex + leftIndex) / 2;
            right = nums[rightIndex];
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] > right) {
                // 中间值大于了右边值，最小值在右边
                leftIndex = mid + 1;
            } else {
                // 中间值不大于右边值，最小值在左边
                rightIndex = mid - 1;
            }
        }
        return nums[leftIndex];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMin(new int[]{1, 2, 3, 4, 5}));
    }
}