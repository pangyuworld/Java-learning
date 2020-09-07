package com.leetcode.p347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/7 9:02 godspeed.zxy Exp $
 */
class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().topKFrequent(new int[]{4,1,-1,2,-1,2,3}, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length < 1) return nums;
        PriorityQueue<Number> minQueue = new PriorityQueue<>((o1, o2) -> o1.rank > o2.rank ? 1 : -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer rank = map.get(num);
            if (rank == null || rank < 1) {
                map.put(num, 1);
            } else {
                map.put(num, rank + 1);
            }
        }
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (minQueue.size() < k) {
                minQueue.add(new Number(set.getKey(), set.getValue()));
            } else {
                Number top = minQueue.peek();
                if (set.getValue() > top.rank) {
                    minQueue.poll();
                    minQueue.add(new Number(set.getKey(), set.getValue()));
                }
            }
        }
        int[] result = new int[k];
        int i = 0;
        for (Number number : minQueue) {
            result[i++] = number.val;
        }
        return result;
    }

    static class Number {
        int val;
        int rank;

        public Number(int val, int rank) {
            this.val = val;
            this.rank = rank;
        }
    }
}