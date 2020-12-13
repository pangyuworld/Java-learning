package com.leetcode.p217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pang
 * @date 2020/12/13
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}