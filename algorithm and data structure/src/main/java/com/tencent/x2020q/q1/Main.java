package com.tencent.x2020q.q1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        List<Integer> list = new LinkedList<>();
        // j表示数组下标，i表示b链表下标
        for (int j = 0, i = 0; i < m ; i++) {
            int val = in.nextInt();
            while (j < n) {
                if (a[j] == val) {
                    list.add(val);
                    j++;
                    break;
                } else if (a[j] < val) {
                    break;
                }
                j++;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i) + " ");
            } else {
                System.out.println(list.get(i));
            }
        }
    }
}