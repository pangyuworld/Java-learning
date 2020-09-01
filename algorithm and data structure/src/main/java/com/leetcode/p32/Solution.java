package com.leetcode.p32;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p32
 * @description:
 * @date 2020/2/13 14:19
 */
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) return 0;
        int left = 0, right = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                left++;
            } else {
                right++;
                if (left == right) {
                    max = Math.max(right * 2, max);
                } else if (left < right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        left = 0;
        right = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                right++;
            } else {
                left++;
                if (left == right) {
                    max = Math.max(right * 2, max);
                } else if (left > right) {
                    left = 0;
                    right = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses("(()"));
    }
}