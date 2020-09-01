package com.leetcode.p83;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p83
 * @description:
 * @date 2020/3/19 22:20
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            while (temp.next != null && temp.val == temp.next.val) {
                deleteNode(temp);
            }
            temp = temp.next;
        }
        return head;
    }

    public void deleteNode(ListNode node) {
        ListNode two = node.next.next;
        node.next = two;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}