package com.mianshi.offer.m61;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Soluition
 * @Package com.mianshi.offer.m61
 * @description:
 * @date 2020/2/14 11:56
 */
class Solution {
    public boolean isStraight(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int zero = 0;
        int[] temp = new int[14];
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num && num > 0) min = num;
            if (num == 0) zero++;
            temp[num]++;
        }
        if (max - min > 4) return false;
        if (max - min < 4 && max - min + zero < 4) return false;
        for (int i = 1; i < temp.length; i++) {
            if (temp[i]>1)return false;
        }
        return true;
    }
}