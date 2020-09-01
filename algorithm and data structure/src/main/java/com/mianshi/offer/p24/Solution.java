package com.mianshi.offer.p24;


import java.util.Stack;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        Stack<ListNode> listNodeQueue = new Stack<>();
        while (head != null) {
            listNodeQueue.add(head);
            head = head.next;
        }
        head = listNodeQueue.pop();
        ListNode result = head;
        while (!listNodeQueue.isEmpty()) {
            head.next = listNodeQueue.pop();
            head = head.next;
        }
        head.next = null;
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}