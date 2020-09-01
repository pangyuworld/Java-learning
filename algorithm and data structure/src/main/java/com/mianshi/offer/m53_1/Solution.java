package com.mianshi.offer.m53_1;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m53_1
 * @description:
 * @date 2020/2/27 0:06
 */
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) return 0;
        int l = 0, r = nums.length-1, sum = 0;
        boolean flag = nums[0] != target;
        while (l < r && flag) {
            int mid = (l + r) / 2;
            if (nums[mid] == target && nums[mid - 1] != target) {
                l = mid;
                break;
            } else if (nums[mid] >= target) {
                // 目标值在左边
                r = mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        for (int i = l;i<nums.length ; i++) {
            if (nums[i] != target) break;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1}, 1));
    }
}