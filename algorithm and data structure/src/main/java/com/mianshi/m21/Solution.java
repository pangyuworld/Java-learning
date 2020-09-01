package com.mianshi.m21;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.m21
 * @description:
 * @date 2020/4/4 9:31
 */
class Solution {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if ((nums[left] & 1) == 0) {
                // 偶数
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        new Solution().exchange(new int[]{1, 2, 3, 4});
    }
}