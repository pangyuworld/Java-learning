package com.leetcode.p830;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p830
 * @description:
 * @date 2020/3/19 20:50
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new LinkedList<>();
        if (S == null || S.length() < 1) return result;
        char[] array = S.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                List<Integer> list = new LinkedList<>();
                list.add(i - 1);
                for (; i < array.length; i++) {
                    if (array[i] != array[i - 1]) {
                        list.add(i - 1);
                        if (list.get(1) - list.get(0) >= 2)
                            result.add(list);
                        break;
                    }
                }
                if (i == array.length) {
                    if (array[i - 1] == array[i - 2]) {
                        list.add(i - 1);
                        if (list.get(1) - list.get(0) >= 2)
                            result.add(list);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largeGroupPositions("aaa"));
    }
}