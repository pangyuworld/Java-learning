package com.lanqiao;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.lanqiao
 * @description:
 * @date 2020/2/27 16:52
 */
public class Solution {
    static int CC = 1000000007;

    public static int getTimeCount(long t) {
        int x = 2;
        int y = 1;
        int z = 0;
        // dpA[i+1]=dpA[i]+dpB[i]
        // doB[i+1]=dpA[i]
        for (long i = 2; i < t; i++) {
            z = x + y;
            if (z >= CC) z -= CC;
            y = x;
            x = z;

        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(getTimeCount(1000000000000L));
    }
}
