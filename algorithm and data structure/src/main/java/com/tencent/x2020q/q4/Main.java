package com.tencent.x2020q.q4;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        if (n == 2) {
            System.out.println(a[0]);
        }
        int[] t = Arrays.copyOf(a, n);
        Arrays.sort(t);
        int la = t[n / 2 - 1];
        int ra = t[n / 2];
        for (int i = 0; i < n; i++) {
            if (a[i] <= la) {
                System.out.println(ra);
            } else {
                System.out.println(la);
            }
        }
    }
}