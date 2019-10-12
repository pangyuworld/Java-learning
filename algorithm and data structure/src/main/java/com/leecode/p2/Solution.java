package com.leecode.p2;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p2
 * @description:
 * @date 2019/10/11 15:05
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers 著作权归领扣网络所有。
 * 商业转载请联系官方授权，非商业转载请注明出处。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 进位标志
        int carryFlag = 0;
        // 要返回的结果
        ListNode result = null;
        // 对返回结果进行递归的链表
        ListNode listNode = new ListNode(0);
        result=listNode;
        // 循环相加，判断条件是只要有一个链表有子节点（没有进位）或者有进位的状态，就可以继续前进
        while (l1 != null || l2 != null || carryFlag > 0) {
            // 如果链表节点位空的话，那就初始化为0就可以了
            l1 = l1 != null ? l1 : new ListNode(0);
            l2 = l2 != null ? l2 : new ListNode(0);
            int sum = l1.val + l2.val + carryFlag;
            carryFlag = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;
            l1=l1.next;
            l2=l2.next;
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode l1, l2;
        l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(l1, l2);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}