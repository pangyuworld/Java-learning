package com.leetcode.p22;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p22
 * @description:
 * @date 2020/2/13 11:23
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if (n == 0) return list;
        getResult(list, 0, 0, "", n);
        return list;
    }

    private void getResult(List<String> list, int open, int close, String sb, int max) {
        if (sb.length() == 2 * max) {
            list.add(sb);
            return;
        }

        if (open < max) {
            getResult(list, open + 1, close, sb + ('('), max);
        }
        if (close < open) {
            getResult(list, open, close + 1, sb + (')'), max);
        }
    }


    private void deleteLastCode(StringBuffer sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }
}