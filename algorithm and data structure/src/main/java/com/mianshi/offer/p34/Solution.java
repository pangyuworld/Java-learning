package com.mianshi.offer.p34;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.p34
 * @description:
 * @date 2020/2/27 21:20
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        getResult(lists, linkedList, root, sum);
        return lists;
    }

    private void getResult(List<List<Integer>> lists, LinkedList<Integer> linkedList, TreeNode root, int sum) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                linkedList.add(root.val);
                List<Integer> res = new LinkedList<>(linkedList);
                lists.add(res);
                linkedList.removeLast();
            }
            return;
        }
        linkedList.add(root.val);
        getResult(lists, linkedList, root.left, sum - root.val);
        getResult(lists, linkedList, root.right, sum - root.val);
        linkedList.removeLast();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.removeLast();
        System.out.println(linkedList);
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