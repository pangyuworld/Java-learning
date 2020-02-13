package com.leecode.p20;

import java.util.Stack;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p20
 * @description:
 * @date 2020/2/13 10:37
 */
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case ')': {
                    if (stack.empty() || stack.pop() != '(') return false;
                }
                break;
                case '}': {
                    if (stack.empty() || stack.pop() != '{') return false;
                }
                break;
                case ']': {
                    if (stack.empty() || stack.pop() != '[') return false;
                }
                break;
                default: {
                    stack.push(c);
                }
            }
        }

        return stack.empty();
    }
}