package com.tencent.q1;

import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            clear();
            int q = sc.nextInt();
            for (int j = 0; j < q; j++) {
                String option = sc.next();
                if (option.equals("PUSH")) {
                    int x = sc.nextInt();
                    push(x);
                } else if (option.equals("TOP")) {
                    System.out.println(top());
                } else if (option.equals("POP")) {
                    pop();
                } else if (option.equals("CLEAR")) {
                    clear();
                } else if (option.equals("SIZE")) {
                    System.out.println(size());
                }
            }
        }
    }

    public static void push(int x) {
        queue.add(x);
    }

    public static void pop() {
        if (queue.size() < 1) {
            System.out.println(-1);
        } else {
            queue.poll();
        }
    }

    public static int top() {
        if (queue.size() < 1) {
            return -1;
        } else {
            return queue.peek();
        }
    }

    public static void clear() {
        queue.clear();
    }

    public static int size() {
        return queue.size();
    }
}