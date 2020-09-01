package com.tencent.q4;

import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static Stack<Integer> q1 = new Stack<>();
    static Stack<Integer> q2 = new Stack<>();

    public static void main(String[] args) {
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String option = sc.next();
            if (option.equals("add")) {
                int x = sc.nextInt();
                add(x);
            } else if (option.equals("poll")) {
                poll();
            } else if (option.equals("peek")) {
                System.out.println(peek());
            }
        }
    }

    public static void add(int x) {
        q1.add(x);
    }

    public static int poll() {
        int result;
        if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.add(q1.pop());
            }
        }
        result = q2.pop();
        return result;
    }

    public static int peek() {
        int result;
        if (q2.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.add(q1.pop());
            }
        }
        result = q2.peek();
        return result;
    }

}