package com.leetcode.p31;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p31
 * @description:
 * @date 2020/2/9 13:22
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        // 从右向左找到第一个升序序列
        int index = -1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i - 1;
                break;
            }
        }
        // 如果没有找到，则直接排序
        if (index < 0) {
            sort(nums, 0);
            return;
        }
        // 如果找到了，那么让这个下标的数与右边最接近并大于它的数进行互换
        int min = Integer.MAX_VALUE;
        int minIndex = index + 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (min > nums[i] && nums[i] > nums[index]) {
                min = nums[i];
                minIndex = i;
            }
        }
        int a = nums[index];
        nums[index] = nums[minIndex];
        nums[minIndex] = a;
        // 然后对右边进行升序排序
        sort(nums, index + 1);

    }

    private void sort(int[] nums, int start) {
        int a=0;
        for (int i = start; i < nums.length - 1; i++) {
            for (int j=i+1;j<nums.length;j++) {
                if (nums[i] > nums[j]) {
                    a = nums[i];
                    nums[i] = nums[j];
                    nums[j] = a;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().nextPermutation(new int[]{3, 2, 1});
    }
}
