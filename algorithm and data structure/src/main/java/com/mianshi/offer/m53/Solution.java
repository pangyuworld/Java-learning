package com.mianshi.offer.m53;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m53
 * @description:
 * @date 2020/2/26 23:49
 */
class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) return 1;
        if (nums[0] != 0) return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] != mid && nums[mid - 1] == mid - 1) {
                // 找到符合条件的数，返回这个数
                return mid;
            } else if (nums[mid] != mid) {
                // 目标数字在左边
                r = mid;
            } else if (nums[mid] == mid) {
                // 目标数字在右边
                l = mid + 1;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9}));
    }
}