package com.leetcode.p637;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new LinkedList<>();
        List<Double> list = new LinkedList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()) {
            double sum = 0;
            int n = 0;
            while (!q1.isEmpty()) {
                TreeNode h = q1.poll();
                sum += h.val;
                n++;
                if (h.left != null) {
                    q2.add(h.left);
                }
                if (h.right != null) {
                    q2.add(h.right);
                }
            }
            list.add(sum / n);
            Queue<TreeNode> q3 = q2;
            q2 = q1;
            q1 = q3;
        }
        return list;
    }
}
