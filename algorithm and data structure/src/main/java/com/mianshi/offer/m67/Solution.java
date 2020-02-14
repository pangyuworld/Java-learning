package com.mianshi.offer.m67;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m67
 * @description:
 * @date 2020/2/14 12:03
 */
class Solution {
    public int strToInt(String str) {
        if (str == null || str.isEmpty()) return 0;
        // 清空左右空格
        str = str.trim();
        if (str == null || str.isEmpty()) return 0;
        boolean isF = false;
        int res = 0;
        char[] chars = str.toCharArray();
        if (chars[0] != '+') {
            if (chars[0] == '-') isF = true;
            else if (chars[0] >= '0' && chars[0] <= '9') {
                res += chars[0] - '0';
            } else {
                return 0;
            }
        }
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int temp = res;
                res = res * 10 + chars[i] - '0';
                if (temp != res / 10) {
                    return isF ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
            } else {
                break;
            }
        }
        return isF ? -res : res;
    }
}