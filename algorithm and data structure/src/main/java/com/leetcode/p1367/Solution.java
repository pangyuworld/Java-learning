package com.leetcode.p1367;


/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1367
 * @description:
 * @date 2020/3/4 13:50
 */
class Solution {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root==null)return false;
        return getResult(root, head, head)||isSubPath(head,root.left)||isSubPath(head,root.right);
    }

    /**
     * 从树种查找链表
     *
     * @param root   查找的树的根节点
     * @param head   查找的链表的头结点
     * @param target 要比对的链表的下个元素
     */
    private boolean getResult(TreeNode root, ListNode head, ListNode target) {
        if (target == null) return true;
        if (root == null) return false;
        if (root.val == target.val) {
            target = target.next;
            return getResult(root.left, head, target) || getResult(root.right, head, target);
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
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

