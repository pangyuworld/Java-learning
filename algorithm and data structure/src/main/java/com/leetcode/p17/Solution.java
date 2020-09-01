package com.leetcode.p17;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p17
 * @description:
 * @date 2020/2/12 13:53
 */
class Solution {

    static char[][] map = new char[][]{
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.isEmpty()) {
            return list;
        }
        char[] chars = digits.toCharArray();
        int index = 0;
        StringBuffer sb = new StringBuffer();
        getResult(list, chars, index, sb);
        return list;
    }

    private void getResult(List<String> list, char[] chars, int index, StringBuffer sb) {
        if (index>=chars.length){
            list.add(sb.toString());
            return;
        }
        for (char c : map[chars[index] - '2']) {
            sb.append(c);
            getResult(list, chars, index + 1, sb);
            deleteLastCode(sb);
        }
    }


    private void deleteLastCode(StringBuffer sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("23");
    }
}