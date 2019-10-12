package com.leecode.p5;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p5
 * @description:
 * @date 2019/10/11 16:23
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class Solution {
    class Edge {
        int left = 0;
        int right = 0;
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            // 如果字符串只有一个字符或者空字符，则最长回文子串就是它本身
            return s;
        } else if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
            // 如果字符串是两个相等的字符
            return s;
        }
        Edge edge = new Edge();
        if (s.charAt(0) == s.charAt(1)){
            edge.left=0;
            edge.right=1;
        }
        for (int i = 1; i < s.length(); i++) {
            // 获得比较过后的左右边界(比较一个)
            Edge edge1 = component(s, i, s.length());
            // 如果新的边界大于旧的边界，则旧的边界等于新的边界
            if (edge1.right - edge1.left > edge.right - edge.left) {
                edge = edge1;
            }
            //  比较两个
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                edge1 = component(s, i, i + 1, s.length());
                // 如果新的边界大于旧的边界，则旧的边界等于新的边界
                if (edge1.right - edge1.left > edge.right - edge.left) {
                    edge = edge1;
                }
            }
        }
        return s.substring(edge.left, edge.right + 1);
    }

    private Edge component(String s, int i, int length) {
        int j = 1;
        Edge edge = new Edge();
        edge.left = i;
        edge.right = i;
        while (true) {
            // 如果超出了边界，那就直接停止
            if (i - j < 0 || i + j >= length) {
                break;
            }
            // 如果没有超出边界
            // 如果两边不相等
            if (s.charAt(i - j) != s.charAt(i + j)) {
                break;
            }
            // 如果两边相等
            edge.right = i + j;
            edge.left = i - j;
            j += 1;
        }
        return edge;
    }

    private Edge component(String s, int i1, int i2, int length) {
        int j = 1;
        Edge edge = new Edge();
        edge.left = i1;
        edge.right = i2;
        while (true) {
            // 如果超出了边界，那就直接停止
            if (i1 - j < 0 || i2 + j >= length) {
                break;
            }
            // 如果没有超出边界
            // 如果两边不相等
            if (s.charAt(i1 - j) != s.charAt(i2 + j)) {
                break;
            }
            // 如果两边相等
            edge.right = i2 + j;
            edge.left = i1 - j;
            j += 1;
        }
        return edge;
    }

    @Test
    public void test() {
        System.out.println(longestPalindrome("ccd"));
        // System.out.println("ccd".substring(0,1));
    }
}
