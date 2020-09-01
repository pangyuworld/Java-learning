package com.leetcode.p34;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p32
 * @description:
 * @date 2020/2/10 10:58
 */
public class Solution {
    /**
     * 二分查找，找到目标值下标，否则返回-1
     *
     * @param nums   数组
     * @param target 目标值
     * @return 目标值所在下标
     */
    public int search(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] > target) {
                // 在左侧寻找
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 在右侧寻找
                left = mid + 1;
            }
        }
        return index;
    }

    /**
     * 寻找目标值左边界
     *
     * @param nums   数组
     * @param target 目标值
     * @return 左边界下标
     */
    public int searchLeftLimit(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                right = mid;
                index++;
            } else if (nums[mid] > target) {
                // 在左侧寻找
                right = mid;
            } else if (nums[mid] < target) {
                // 在右侧寻找
                left = mid + 1;
            }
        }
        if (index < 0) return -1;
        // 如何处理-1
        return right;
    }

    /**
     * 寻找目标值右边界
     *
     * @param nums   数组
     * @param target 目标值
     * @return 右边界下标
     */
    public int searchRightLimit(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
                index++;
            } else if (nums[mid] > target) {
                // 在左侧寻找
                right = mid;
            } else if (nums[mid] < target) {
                // 在右侧寻找
                left = mid + 1;
            }
        }
        if (index < 0) return -1;
        return left - 1;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeftLimit(nums, target),searchRightLimit(nums, target)};
    }
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 8}, 7));
        System.out.println(new Solution().searchLeftLimit(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 8}, 7));
        System.out.println(new Solution().searchRightLimit(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 8}, 7));
        System.out.println(Arrays.toString(new Solution().searchRange(new int[]{1, 2, 2, 3, 3, 4, 5, 6, 8}, 3)));
    }
}
