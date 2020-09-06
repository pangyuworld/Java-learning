package com.leetcode.p107;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) {
 * val = x; } }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resultList = new LinkedList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<TreeNode> treeNodes2 = new LinkedList<>();
        treeQueue.add(root);
        while (true) {
            List<Integer> intList = new LinkedList<>();
            while (!treeQueue.isEmpty()) {
                TreeNode node = treeQueue.poll();
                if (node.left != null) {
                    treeNodes2.add(node.left);
                }
                if (node.right != null) {
                    treeNodes2.add(node.right);
                }
                intList.add(node.val);
            }
            resultList.add(intList);
            if (treeNodes2.isEmpty()) {
                break;
            }
            Queue<TreeNode> temp = treeQueue;
            treeQueue = treeNodes2;
            treeNodes2 = temp;
        }
        Collections.reverse(resultList);
        return resultList;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
