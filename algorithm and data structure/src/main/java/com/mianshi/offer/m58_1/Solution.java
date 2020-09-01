package com.mianshi.offer.m58_1;

import java.util.Stack;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m58_1
 * @description:
 * @date 2020/2/27 0:20
 */
class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < s.length()) {
            int i = s.indexOf(' ', index);
            if (i < 0) i = s.length();
            String sub = s.substring(index, i);
            if (sub.equals("")) {
                index++;
                continue;
            }
            stack.push(sub);
            index = i;
        }
        if (stack.empty()) return "";
        StringBuffer sb = new StringBuffer(stack.pop());
        while (!stack.empty()) {
            sb.append(" ").append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(" ".indexOf(' ', 0));
        System.out.println(new Solution().reverseWords("hello  world"));
    }
}