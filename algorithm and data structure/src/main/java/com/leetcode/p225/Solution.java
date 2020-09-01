package com.leetcode.p225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p225
 * @description:
 * @date 2020/3/4 11:12
 */
class MyStack {

    private Queue<Integer> queueInput, queueOutput;

    private int size;

    /** Initialize your data structure here. */
    public MyStack() {
        queueInput = new LinkedList();
        size = 0;
        queueOutput = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queueInput.add(x);
        size++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (size > 1) {
            queueOutput.add(queueInput.poll());
            size--;
        }
        int result = queueInput.size() == 1 ? queueInput.poll() : queueOutput.poll();
        while (!queueOutput.isEmpty()) {
            queueInput.add(queueOutput.poll());
            size++;
        }
        size--;
        return result;
    }

    /** Get the top element. */
    public int top() {
        while (size > 1) {
            queueOutput.add(queueInput.poll());
            size--;
        }
        int result = queueInput.size() == 1 ? queueInput.poll() : queueOutput.poll();
        queueOutput.add(result);
        while (!queueOutput.isEmpty()) {
            queueInput.add(queueOutput.poll());
            size++;
        }
        size--;
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return !(size > 0);
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack(); obj.push(x); int param_2 =
 * obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
 */