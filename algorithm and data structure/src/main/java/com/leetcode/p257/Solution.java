package com.leetcode.p257;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        System.out.println(new Solution().binaryTreePaths(node));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> strList = new LinkedList<>();
        if (null == root) return strList;
        StringBuffer sb = new StringBuffer();
        traverse(root, sb, strList);
        return strList;
    }

    private void traverse(TreeNode root, StringBuffer sb, List<String> strList) {
        if (root.left == null && root.right == null) {
            int len = String.valueOf(root.val).length();
            sb.append(root.val);
            strList.add(sb.toString());
            sb.delete(sb.length() - len, sb.length());
            return;
        }
        int len = String.valueOf(root.val).length();
        sb.append(root.val).append("->");
        if (root.left != null) {
            traverse(root.left, sb, strList);
        }
        if (root.right != null) {
            traverse(root.right, sb, strList);
        }
        sb.delete(sb.length() - len - 2, sb.length());
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