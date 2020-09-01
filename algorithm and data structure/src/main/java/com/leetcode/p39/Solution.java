package com.leetcode.p39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p39
 * @description:
 * @date 2020/2/10 11:38
 */
class Solution {
    // 定义结果
    private List<List<Integer>> list = new LinkedList<>();

    // 定义临时变量
    private List<Integer> integerList = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            if (candidates[i]>target)break;
            integerList.add(candidates[i]);
            getResult(i, candidates, target - candidates[i]);
            integerList.remove(integerList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}