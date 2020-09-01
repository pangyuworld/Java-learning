package com.leetcode.p3;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p3
 * @description:
 * @date 2019/10/11 15:34
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = s.length() > 0 ? 1 : 0;
        String littleStr = s.substring(left, right);
        int max = right - left;
        while (right < s.length()) {
            // 获取到右边新进来的字符
            char str = s.charAt(right);
            // 这个字符在短字符串里面有没有，有的话iChar>=0
            int iChar = littleStr.indexOf(str);
            if (iChar >= 0) {
                // 如果有的话，那就缩短左边界，缩短距离为缩短到不包含那个字符
                left += 1 + iChar;
            }
            // 重新初始化字符串
            littleStr = s.substring(left, ++right);
            max = Math.max(max, right - left);
        }
        return max;
    }

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring(""));
    }
}
