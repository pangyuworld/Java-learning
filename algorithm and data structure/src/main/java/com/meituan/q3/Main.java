package com.meituan.q3;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String str = sc.nextLine();
        int daxie = 0, xiaoxie = 0;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z') {
                xiaoxie++;
            } else if (aChar >= 'A' && aChar <= 'Z') {
                daxie++;
            }
        }
        System.out.println(Math.min(Math.abs(daxie - str.length() / 2), Math.abs(xiaoxie - str.length() / 2)));
    }
}