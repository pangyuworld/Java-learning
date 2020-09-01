package com.mianshi.offer.m54;


/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m54
 * @description:
 * @date 2020/2/15 10:27
 */
class Solution {
    int i =0;
    int res=0;
    public int kthLargest(TreeNode root, int k) {
        getResult(root,k);

        return res;
    }

    private void getResult(TreeNode root, int k) {
        if (root==null)return;
        // 左
        getResult(root.right,k);
        // 根
        i++;
        if (i ==k){
            res=root.val;
        }
        // 右
        getResult(root.left,k);
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