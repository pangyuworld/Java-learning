package com.mianshi.offer.m66;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m66
 * @description:
 * @date 2020/2/14 13:14
 */
class Solution {
    // public int[] constructArr(int[] a) {
    //     if (a == null || a.length < 1) return a;
    //     // a =      1   2   3   4   5
    //     int[] b = new int[a.length];
    //     b[0] = 1;
    //     // b =      1   1   2   6   24
    //     for (int i = 1; i < a.length; i++) {
    //         b[i] = a[i - 1] * b[i - 1];
    //     }
    //     int temp=1;
    //     // temp =   120 120 40  30  24
    //     for (int i = b.length - 2; i >= 0; i--) {
    //         temp*=a[i+1];
    //         b[i]*=temp;
    //     }
    //     return b;
    // }
    public int[] constructArr(int[] a) {
        if (a == null || a.length < 1) return a;
        int[] res = new int[a.length];
        int[] start = new int[a.length];
        int[] end = new int[a.length];
        start[0] = 1;
        end[0] = a[a.length - 1];
        for (int i = 1; i < start.length; i++) {
            start[i] = a[i] * start[i - 1];
            end[i] = end[i - 1] * a[a.length - 1 - i];
        }
        for (int i = 0; i < res.length; i++) {
            if (i == 0) {
                res[i] = end[res.length - 2];
                continue;
            }
            if (i == res.length - 1) {
                res[i] = start[res.length - 2] * a[0];
                continue;
            }
            res[i] = start[i - 1] * end[res.length - 2 - i];
        }
        System.out.println(Arrays.toString(start));
        System.out.println(Arrays.toString(end));
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        new Solution().constructArr(new int[]{7, 2,2,4});
    }

}