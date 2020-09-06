package com.meituan.q4;

import java.util.*;

/**
 * 题目描述：
 * 在小团的公司中，有n位员工。除了最高领导——小团外，每位员工有且仅有一位直接领导。所以，公司内从属关系可以看成一棵树。
 *
 * 现在，公司接到一个项目，需要重新划分这n位员工的从属关系。新的划分描述如下：
 *
 * 1.每个人要么没有下属，要么有至少两个直接下属（即至少有两人的直接领导为这个人）
 *
 * 2.第 i 个人的下属（包括自己）有恰好 ai 个。
 *
 * 请注意，直接下属和下属（包括自己）可分别看做树上点的"儿子"和"子树"。
 *
 * 请问是否存在这么一种关系？注意，输入不会给出最高领导的编号。
 *
 *
 *
 * 输入描述
 * 输入包含多组数据。
 *
 * 对于每组数据，第一行一个整数n，表示公司有n个人。
 *
 * 接下来一行n个数，第 i 个数为ai，含义如题面所示。
 *
 * （n≤24，数据组数在10以内）
 *
 * 输出描述
 * 对每组数据，输出一行"YES"或"NO"，代表是否存在这一种从属关系。
 *
 *
 * 样例输入
 * 3
 * 1 1 3
 * 2
 * 1 2
 * 样例输出
 * YES
 * NO
 *
 * 提示
 * 对于第一组样例，1和2的直接领导均为3即可
 * 对于第二组样例，无法构造出符合题目要求的关系。注意每个有下属的人至少有2个直接下属。
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            int n = sc.nextInt();
            int[] array = new int[n];
            int max = 0;
            boolean suc = false;
            int[] a1 = new int[12];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
                if (array[i] % 2 == 0) {
                    suc = true;
                }
                if (array[i] >= max) {
                    max = array[i];
                }
                if (array[i] > 24) {
                    suc = true;
                    continue;
                }
                a1[array[i] / 2]++;
            }
            if (n == 1 && array[0] == 1) {
                System.out.println("YES");
                continue;
            }
            if (n % 2 != 1 || suc || a1[1] * 2 > a1[0]) {
                System.out.println("NO");
                continue;
            }
            a1[0] -= a1[1] * 2 + a1[2];
            a1[1] -= a1[2];
            for (int i = 3; i <= max / 2; i++) {
                if (a1[i - 1] > 0) {
                    a1[0] -= a1[i];
                    a1[i - 1] -= a1[i];
                } else {
                    a1[i - 2] -= a1[i] * 2;
                }
            }
            for (int i = 0; i < max / 2; i++) {
                if (a1[i] > 0) {
                    suc = true;
                    break;
                }
            }
            if (suc) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        while (!"\n".equals(sc.nextLine()));
    }
}
