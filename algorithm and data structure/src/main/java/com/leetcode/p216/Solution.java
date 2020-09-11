package com.leetcode.p216;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/11 9:13 godspeed.zxy Exp $
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0) {
            return new LinkedList<>();
        }
        List<List<Integer>> resultList = new LinkedList<>();
        Set<Integer> result = new HashSet<>();
        doSome(k, 1, 0, n, 0, result, resultList);

        return resultList;
    }

    private void doSome(int maxIndex, int start, int index, int sum, int now, Set<Integer> result, List<List<Integer>> resultList) {
        if (index > maxIndex) {
            return;
        }
        if (sum == now && index == maxIndex) {
            resultList.add(new LinkedList<>(result));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (now + i > sum)
                break;
            if (result.contains(i)) {
                continue;
            }
            result.add(i);
            doSome(maxIndex, i + 1, index + 1, sum, now + i, result, resultList);
            result.remove(i);
        }

    }

}