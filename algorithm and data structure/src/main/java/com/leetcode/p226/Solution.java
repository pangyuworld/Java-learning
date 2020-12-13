package com.leetcode.p226;

import com.leetcode.TreeNode;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/16 9:20 godspeed.zxy Exp $
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        reversion(root);
        return root;
    }

    private void reversion(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        reversion(root.right);
        reversion(root.left);
    }
}