package com.leetcode.p566;

import java.util.Arrays;

/**
 * @author Pang
 * @date 2021/2/17
 */
class Solution {


    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int height = nums.length;
        int width = nums[0].length;
        if (height * width != r * c) {
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = nums[i / width][i % width];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, 2, 2)));
    }
}