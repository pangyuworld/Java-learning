package com.leetcode.p697;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pang
 * @date 2021/2/20
 */
public class Solution {
    class Node {
        int appear = 0;
        int startIndex = 0;
        int endIndex = 0;
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Node> map = new HashMap<>();
        Node maxNode = new Node();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Node node = map.get(num);
                node.appear++;
                node.endIndex = i;
                if (maxNode.appear < node.appear) {
                    maxNode = node;
                } else if (maxNode.appear == node.appear) {
                    if (maxNode.endIndex - maxNode.startIndex > node.endIndex - node.startIndex) {
                        maxNode = node;
                    }
                }

            } else {
                Node node = new Node();
                node.startIndex = i;
                node.endIndex = i;
                node.appear++;
                map.put(num, node);
            }
        }
        Node node = maxNode;
        int res = node.endIndex - node.startIndex;
        return res + 1;
    }

//    public static void main(String[] args) {
//        System.out.println(new Solution().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
//    }
}