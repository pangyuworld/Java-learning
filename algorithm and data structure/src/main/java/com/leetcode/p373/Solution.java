package com.leetcode.p373;

import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> resultList = new  LinkedList<>();
        if (nums1.length<1||nums2.length<1)return resultList;
        
        return resultList.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    }
}
