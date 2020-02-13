package com.leecode.p13;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p13
 * @description:
 * @date 2020/2/12 13:16
 */
class Solution {
    public int romanToInt(String s) {
        String[] strs = new String[]{
                "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = new int[]{
                1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        StringBuffer sb = new StringBuffer(s);
        int index = 0, result = 0;
        while (sb.length() > 0) {
            while (sb.length() >= strs[index].length() && sb.substring(0, strs[index].length())
                    .toString()
                    .equals(strs[index])) {
                result += values[index];
                sb.replace(0, strs[index].length(), "");
            }
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("DCXXI"));
    }
}