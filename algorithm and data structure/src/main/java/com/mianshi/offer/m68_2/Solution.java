package com.mianshi.offer.m68_2;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m68_1.m68_2
 * @description:
 * @date 2020/2/14 10:06
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 二叉搜索树
        if (root == null || root.val == p.val || root.val == q.val) return root;
        if (root.val > p.val && root.val < q.val) return root;
        if (root.val < p.val && root.val > q.val) return root;
        if (root.val > p.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
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