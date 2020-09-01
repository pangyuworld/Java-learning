package com.leetcode.p219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p219
 * @description:
 * @date 2020/4/3 13:01
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums==null||nums.length==0)return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n;
            if ((n = map.get(nums[i])) != null) {
                if (n - i <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}