package com.leecode.p24;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p24
 * @description:
 * @date 2020/2/13 11:57
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null)return head;
        ListNode l1, l2;
        l1 = head;
        l2 = head.next;
        boolean first = true;
        ListNode temp = null;
        while (l2 != null) {
            l1.next = l2.next;
            l2.next = l1;
            if (first) {
                head = l2;
                first = false;
            } else {
                temp.next = l2;
            }
            temp = l1;
            if (l1.next==null || l1.next.next == null) break;
            l1 = l1.next;
            l2 = l1.next;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        new Solution().swapPairs(listNode);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}