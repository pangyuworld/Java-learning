package com.mianshi.offer.m55;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m55
 * @description:
 * @date 2020/2/14 11:26
 */
public class Solution {
    boolean res = false;

    public boolean isBalanced(TreeNode root) {
        getResult(root);
        return res;
    }

    private int getResult(TreeNode root) {
        if (root == null) return 0;
        int left = getResult(root.left);
        int right = getResult(root.right);
        if (left - right > 1) res = true;
        if (right - left > 1) res = true;
        return left > right ? left + 1 : right + 1;
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