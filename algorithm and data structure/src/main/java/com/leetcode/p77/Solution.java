package com.leetcode.p77;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/8 9:12 godspeed.zxy Exp $
 */
class Solution {
    static Set<Integer> numSet = new HashSet<>();
    static Set<Integer> failSet = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(new Solution().combine(1, 1));
    }

    public static void doSome(List<List<Integer>> result, Stack<Integer> sb, int k) {
        for (Integer i : numSet) {
            if (failSet.contains(i) || (!sb.empty() && i < sb.peek())) {
                continue;
            }
            sb.add(i);
            failSet.add(i);
            if (sb.size() == k) {
                result.add(new LinkedList<>(sb));
            }
            doSome(result, sb, k);
            failSet.remove(i);
            sb.pop();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        if (n==1&&k==1) {
            result.add(Collections.singletonList(1));
            return result;
        }
        for (int i = 1; i <= n; i++) {
            numSet.add(i);
        }
        doSome(result, new Stack<>(), k);
        return result;
    }
}