package com.leetcode.p726;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p726
 * @description:
 * @date 2020/4/4 9:59
 */
class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        Stack<Integer> block = new Stack<>();
        char[] chars = formula.toCharArray();
        for (int i = 0; i < chars.length; ) {
            if (chars[i] == '(') {
                block.push(i);
                i++;
                continue;
            } else if (chars[i] == ')') {
                Integer left = block.pop();
                Integer right = i;
                i++;
                Integer blockCount = getElementCount(chars, i);
                for (int j = left + 1; j <= right - 1; j++) {
                    String element = getNextElement(chars, i);
                    i += element.length();
                    Integer elementCount = getElementCount(chars, i);
                    i += elementCount < 2 ? 0 : elementCount.toString().length();
                    map.put(element, map.get(element) + elementCount * (blockCount - 1));
                }
                continue;
            }
            // 先不计算括号
            String element = getNextElement(chars, i);
            i += element.length();
            Integer elementCount = getElementCount(chars, i);
            i += elementCount < 2 ? 0 : elementCount.toString().length();
            map.put(element, elementCount);
        }
        StringBuffer sb = new StringBuffer();
        for (String s : map.keySet()) {
            sb.append(s);
            sb.append(map.get(s) > 1 ? map.get(s) : "");
        }
        return sb.toString();
    }

    /**
     * 获得下一个元素名
     *
     * @param chars 表达式
     * @param index 当前下标
     * @return 下一个元素名
     */
    private String getNextElement(char[] chars, int index) {
        StringBuffer sb = new StringBuffer();
        sb.append(chars[index]);
        index++;
        while (index < chars.length && chars[index] >= 'a' && chars[index] <= 'z') {
            sb.append(chars[index]);
            index++;
        }
        return sb.toString();
    }

    /**
     * 获得当前元素的元素数量
     *
     * @param chars 表达式
     * @param index 当前下标
     * @return 当前元素数量
     */
    private Integer getElementCount(char[] chars, int index) {
        StringBuffer sb = new StringBuffer();
        while (index < chars.length && chars[index] >= '0' && chars[index] <= '9') {
            sb.append(chars[index]);
            index++;
        }
        return sb.length() < 1 ? 1 : Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countOfAtoms("Mg(OH)2"));
    }
}