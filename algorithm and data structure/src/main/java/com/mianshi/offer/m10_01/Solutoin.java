package com.mianshi.offer.m10_01;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solutoin
 * @Package com.mianshi.offer.m10_01
 * @description:
 * @date 2020/3/4 12:32
 */
class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        m--;
        n--;
        while (index >= 0) {
            if (m < 0) {
                A[index--] = B[n--];
                continue;
            } else if (n < 0) {
                A[index--] = A[m--];
                continue;
            }
            if (A[m] > B[n]) {
                A[index--] = A[m--];
            } else {
                A[index--] = B[n--];
            }
        }
    }
}