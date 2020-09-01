package com.leetcode.p19;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p19
 * @description:
 * @date 2020/2/12 14:11
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode startNode = head;
        ListNode targetNode = null;
        int step = 0;
        while (head.next != null) {
            if (step == n - 1) {
                targetNode = startNode;
            } else if (step > n - 1) {
                targetNode = targetNode.next;
            }
            head = head.next;
            step++;
        }
        if (step == n-1) return startNode.next;
        targetNode.next = targetNode.next.next;
        return startNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        new Solution().removeNthFromEnd(listNode, 5);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}