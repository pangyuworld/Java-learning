package com.leetcode.p11;

/**
 * @author godspeed.zxy
 * @version : Solution, v0.1 2022-02-13 9:02 下午 godspeed.zxy Exp $
 */
public class Solution {
    public int maxArea(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        // 定义左右边距
        int leftIndex = 0, rightIndex = array.length - 1;
        int leftValue = 0, rightValue = 0;
        // 定义最大面积
        int max = Integer.MIN_VALUE;
        while (leftIndex < array.length && rightIndex >= 0 && leftIndex <= rightIndex) {
            leftValue = array[leftIndex] > leftValue ? array[leftIndex] : leftValue;
            rightValue = array[rightIndex] > rightValue ? array[rightIndex] : rightValue;
            int height = Math.min(leftValue, rightValue);
            max = height * (rightIndex - leftIndex) > max ? height * (rightIndex - leftIndex) : max;
            System.out.println(max);
            if (leftValue > rightValue) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
