package com.leecode.p21;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p21
 * @description:
 * @date 2020/2/13 10:46
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return l1;
        else if (l2 == null) return l1;
        else if (l1 == null) return l2;
        // 第一步，将l1表示为比较小的那个链表（开头比较小）
        ListNode start;
        if (l1.val > l2.val) {
            start = l1;
            l1 = l2;
            l2 = start;
            start = l1;
        } else {
            start = l1;
        }
        // 保留原始节点
        ListNode temp;
        while (l1 != null) {
            while (l2 != null && l1.next != null && l2.val <= l1.next.val) {
                temp = l2.next;
                // 插入节点
                l2.next = l1.next;
                l1.next = l2;
                l2 = temp;
            }
            if (l1.next == null && l2 != null) {
                // 插入节点
                l1.next = l2;
                l2 = null;
            }
            l1 = l1.next;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-9);
        listNode.next = new ListNode(3);
        // listNode.next.next = new ListNode(3);
        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(7);
        // listNode1.next.next = new ListNode(4);
        new Solution().mergeTwoLists(listNode, listNode1);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}