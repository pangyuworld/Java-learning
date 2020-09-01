package com.leetcode.p168;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p168
 * @description:
 * @date 2020/3/19 23:06
 */
class Solution {
    public String convertToTitle(int n) {
        StringBuffer s = new StringBuffer();
        while (n > 0) {
            int mod = (n - 1) % 26;
            char c = (char) ('A' + mod);
            s.insert(0, c);
            n = (n - 1) / 26;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(701));
    }
}