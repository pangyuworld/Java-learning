package com.mianshi.offer.m48;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m48
 * @description:
 * @date 2020/2/15 10:41
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int max = 0;
        int left = 0;
        for (int i = 1; i < s.length(); i++) {
            String str = s.substring(left, i);
            char c = s.charAt(i);
            int index = str.indexOf(c);
            if (index < 0) {
                max = Math.max(max, i - left);
            } else {
                left = left + index + 1;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
    }
}