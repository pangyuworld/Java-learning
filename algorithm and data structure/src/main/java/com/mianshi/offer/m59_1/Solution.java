package com.mianshi.offer.m59_1;

import java.util.LinkedList;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m59_1
 * @description:
 * @date 2020/2/14 13:48
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1) return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        int resIndex = 0;
        // System.out.println(queue);
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.getLast()]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i - queue.getFirst() >= k) {
                queue.removeFirst();
            }
            if (i >= k - 1) res[resIndex++] = nums[queue.getFirst()];
        }
        return res;
    }

    public static void main(String[] args) {

        new Solution().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }
}