package com.mianshi.offer.m55_1;


/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m55_1
 * @description:
 * @date 2020/2/27 21:07
 */
class Solution {
    public static int res = 0;

    public int maxDepth(TreeNode root) {
        getResult(root, 0);
        return res;
    }

    private void getResult(TreeNode root, int dep) {
        if (root == null) {
            res = Math.max(res, dep);
        }
        getResult(root.left, dep + 1);
        getResult(root.right, dep + 1);
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