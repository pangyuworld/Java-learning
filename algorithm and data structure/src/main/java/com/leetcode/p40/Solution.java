package com.leetcode.p40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p40
 * @description:
 * @date 2020/2/10 12:20
 */
class Solution {
    // 定义结果
    private List<List<Integer>> list = new LinkedList<>();

    // 定义临时变量
    private List<Integer> integerList = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        getResult(0, candidates, target);
        return list;
    }

    private void getResult(int start, int[] candidates, int target) {
        // 终止条件
        if (target < 0) return;
        else if (target == 0) list.add(new LinkedList<>(integerList));

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break;
            integerList.add(candidates[i]);
            getResult(i + 1, candidates, target - candidates[i]);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
            integerList.remove(integerList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
    }
}