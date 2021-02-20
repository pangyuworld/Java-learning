package com.leetcode.p1004;

/**
 * @author Pang
 * @date 2021/2/19
 */
class Solution {
    public int longestOnes(int[] A, int K) {
        if (A.length <= 0) return 0;
        int num = 0, max = 0;
        int zero = 0;
        for (int i = 0, j = 0; i < A.length && j < A.length - 1; ) {
            if (A[j] == 0) {
                if (zero < K) {
                    num++;
                    zero++;
                    if (max < num) {
                        max = num;
                    }
                    j++;
                } else {
                    while (i < j) {
                        i++;
                        num--;
                        if (A[i] == 0) {
                            zero--;
                            break;
                        }
                    }
                }
            } else if (A[j] == 1) {
                num++;
                if (max < num) {
                    max = num;
                }
                j++;
            }
        }
        return max ;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        System.out.println(new Solution().longestOnes(a, 2));
        a = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(new Solution().longestOnes(a, 3));
        a = new int[]{1, 0, 0, 1};
        System.out.println(new Solution().longestOnes(a, 1));
        a = new int[]{1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1};
        System.out.println(new Solution().longestOnes(a, 8));
    }
}