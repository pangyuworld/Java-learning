package com.leetcode.p23;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p23
 * @description:
 * @date 2020/2/29 11:16
 */
class Solution {


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            while (listNode != null) {
                queue.add(listNode.val);
                listNode = listNode.next;
            }
        }
        if (queue.isEmpty()) return null;
        ListNode head = new ListNode(queue.poll());
        ListNode result = head;
        while (!queue.isEmpty()) {
            head.next = new ListNode(queue.poll());
            head = head.next;
        }
        return result;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(4);
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(4);
        queue.add(2);
        queue.add(6);
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}