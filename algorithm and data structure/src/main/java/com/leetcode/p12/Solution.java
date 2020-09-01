package com.leetcode.p12;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p12
 * @description:
 * @date 2020/2/12 12:59
 */
public class Solution {
    public String intToRoman(int num) {
        String[] strs = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (num > 0) {
            int count = num / values[index];
            while (count-- > 0) {
                sb.append(strs[index]);
            }
            num %= values[index];
            index++;
        }
        return sb.toString();
    }
}