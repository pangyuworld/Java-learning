package com.leetcode.p25;

import java.util.Stack;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p25
 * @description:
 * @date 2020/2/29 12:33
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        Stack<ListNode> stack = new Stack<>();
        // 标志着是否为第一次
        boolean flag = true;
        ListNode firstResult = null;
        ListNode left = null;
        ListNode right = null;
        while (head != null) {
            stack.push(head);
            head = head.next;
            if (stack.size() == k) {
                // 如果栈满了，那就可以翻转链表了
                left = stack.pop();
                if (flag) {
                    firstResult = left;
                    flag = false;
                } else {
                    right.next = left;
                }
                while (!stack.isEmpty()) {
                    left.next = stack.pop();
                    left = left.next;
                }
                left.next = head;
                right = left;
            }
        }
        return firstResult;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode = new Solution().reverseKGroup(listNode, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}