package com.leetcode.p54;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p54
 * @description:
 * @date 2020/2/11 13:30
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null || matrix.length < 1) return list;
        int h = 0;
        int w = 0;
        int n = 0;
        while (n <= matrix.length / 2) {
            // 1 2 3
            // 5
            while (w < matrix[h].length - n - n) {
                list.add(matrix[h + n][n + w++]);
                // System.out.printf("%2d ", matrix[h + n][n + w++]);
            }
            w--;
            h++;
            if (h >= matrix.length) break;
            // 6 9
            // 6 9
            while (h < matrix.length - n - n) {
                list.add(matrix[n + h++][n + w]);
                // System.out.printf("%2d ", matrix[n + h++][n + w]);
            }
            h--;
            w--;
            if (w < 0) break;
            // 8 7
            while (w >= n) {
                list.add(matrix[n + h][n + w--]);
                // System.out.printf("%2d ", matrix[n + h][n + w--]);
            }
            w++;
            h--;
            if (w >= matrix[0].length) break;
            // 4
            while (h >= n * 2 + 1) {
                list.add(matrix[n + h--][n + w]);
                // System.out.printf("%2d ", matrix[n + h--][n + w]);
            }
            n++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}}));
        // System.out.println(new Solution().spiralOrder(new int[][]{new int[]{1,2}, new int[]{3,4}, new int[]{4}}));
    }
}