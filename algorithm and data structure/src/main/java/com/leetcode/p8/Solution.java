package com.leetcode.p8;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p8
 * @description:
 * @date 2020/2/12 12:04
 */
class Solution {
    public int myAtoi(String str) {
        // 去空格
        str = str.trim();
        char[] chars = str.toCharArray();
        if (chars.length<1)return 0;
        int result = 0;
        boolean isZ = true;
        if (chars[0] == '+') {
            isZ = true;
        } else if (chars[0] == '-') {
            isZ = false;
        } else if (chars[0] >= '0' && chars[0] <= '9') {
            result += chars[0] - '0';
        } else {
            return 0;
        }
        for (int i = 1; i < chars.length; i++) {
            if (!(chars[i] >= '0' && chars[i] <= '9')) {
                break;
            }
            int temp = result;
            result = result * 10 + (isZ ? chars[i] - '0' : -1 * (chars[i] - '0'));
            if (result / 10 != temp) {
                return isZ ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // System.out.println(""+(-9/10==0));
        System.out.println(new Solution().myAtoi("   -9"));
    }
}