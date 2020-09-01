package com.leetcode.p6;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p6
 * @description:
 * @date 2019/10/11 17:09 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 N 字形排列。
 */
public class Solution {

    public String convert(String s, int numRows) {
        StringBuffer result = new StringBuffer();
        if (numRows<=1){
            return s;
        }
        // 输出第1行
        for (int j = 0; (numRows - 1) * 2 * j < s.length(); j++) {
            int index = (numRows - 1) * 2 * j;
            result.append(s.charAt(index));
        }
        // 输出中间部分
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = 0; (numRows - 1) * 2 * j + i < s.length(); j++) {
                int index = (numRows - 1) * 2 * j + i;
                result.append(s.charAt(index));
                index = (numRows - 1) * 2 * (j + 1) - i;
                if (index < s.length()) {
                    result.append(s.charAt(index));
                }
            }
        }
        // 输出最后一行
        for (int j = 0; (numRows - 1) * 2 * j + numRows - 1 < s.length(); j++) {
            int index = (numRows - 1) * 2 * j + numRows - 1;
            result.append(s.charAt(index));
        }
        return result.toString();
    }

    @Test
    public void test() {
        System.out.println(convert("A", 1));
    }
}
