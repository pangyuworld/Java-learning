package com.mianshi.offer.m50;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m50
 * @description:
 * @date 2020/2/27 21:45
 */
class Solution {
    public char firstUniqChar(String s) {
        if (s.isEmpty()) return ' ';
        int[] cont = new int[26];
        for (char c : s.toCharArray()) {
            cont[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (cont[c - 'a'] == 1) return c;
        }
        return ' ';
    }
}