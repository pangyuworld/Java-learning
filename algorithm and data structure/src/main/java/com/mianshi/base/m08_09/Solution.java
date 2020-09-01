package com.mianshi.base.m08_09;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.base.m08_09
 * @description:
 * @date 2020/3/19 21:14
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        if (n < 1) return list;
        getResult(list, 0, 0, "", n);
        return list;
    }

    private void getResult(List<String> list, int open, int close, String str, int n) {
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }

        if (open < n) {
            getResult(list, open + 1, close, str + "(", n);
        }

        if (close < open) {
            getResult(list, open, close + 1, str + ")", n);
        }
    }
}