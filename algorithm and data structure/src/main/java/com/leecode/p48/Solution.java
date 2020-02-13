package com.leecode.p48;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p48
 * @description:
 * @date 2020/2/11 12:21
 */
class Solution {
    public void rotate(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        if (height <= 1 && width <= 1) return;
        int x;
        // 旋转最外围的一圈
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                // x=0,0
                x = matrix[i][j];
                // 0,0=2,0
                matrix[i][j] = matrix[height - 1 - j][i];
                // 2,0=2,2
                matrix[height - 1 - j][i] = matrix[height - 1 - i][width - 1 - j];
                // 2,2=0,2
                matrix[height - 1 - i][width - 1 - j] = matrix[j][width - 1 - i];
                // 0,2=x
                matrix[j][width - 1 - i] = x;
            }
        }

        //------//
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%2d ", anInt);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Solution().rotate(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        });
        System.out.println("------------");
        new Solution().rotate(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        });

        System.out.println("------------");
        new Solution().rotate(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12},
                new int[]{13, 14, 15, 16}
        });
        System.out.println("------------");
        new Solution().rotate(new int[][]{
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        });
    }
}