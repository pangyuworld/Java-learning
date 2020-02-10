package com.leecode.p42;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p42
 * @description:
 * @date 2020/2/10 13:36
 */
class Solution {
    int[] leftMaxBorder, rightMaxBorder;

    public int trap(int[] height) {
        leftMaxBorder = new int[height.length];
        rightMaxBorder = new int[height.length];
        int sumArea = 0;
        for (int i = 0; i < height.length; i++) {
            int left = getLeftBorder(i, height);// 寻找左边界
            int right = getRightBorder(i, height);// 寻找右边界
            int border = Math.min(left, right);// 边界最小值
            sumArea += border - height[i];// 面积
        }
        return sumArea;
    }


    private int getLeftBorder(int index, int[] height) {
        if (index == 0) {
            leftMaxBorder[index] = height[index];
        } else {
            leftMaxBorder[index] = Math.max(leftMaxBorder[index - 1], height[index]);
        }
        return leftMaxBorder[index];
    }

    private int getRightBorder(int index, int[] height) {
        if (index==0) {
            for (int i = 0; i < height.length; i++) {
                if (i == 0) {
                    rightMaxBorder[height.length - i - 1] = height[height.length - 1 - i];
                } else {
                    rightMaxBorder[height.length - i - 1] = Math.max(rightMaxBorder[height.length - i], height[height.length - 1 - i]);
                }
            }
        }
        return rightMaxBorder[index];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}