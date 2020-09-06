package com.meituan.q1;

import java.util.*;

/**
 * 题目描述：
 * A国和B国正在打仗，他们的目的是n块土地。现在，A国和B国暂时休战，为了能合理分配这一些土地，AB国开始协商。
 *
 * A国希望得到这n块土地中的p块土地，B国希望得到这n块土地中的q块土地。每个国家都将自己希望得到的土地编号告诉了小团和小美——两位战争调和人。
 *
 * 你需要帮小团和小美计算，有多少块土地是只有A国想要的，有多少块土地是只有B国想要的，有多少块土地是两个国家都想要的。
 *
 *
 *
 * 输入描述
 * 输入第一行包含三个整数n,p,q，含义如题意所示
 *
 * 接下来一行p个整数，空格隔开，第 i 个整数代表A国需要的土地编号ai
 *
 * 接下来一行q个整数，空格隔开，第 i 个整数代表B国需要的土地编号bi
 *
 * 土地编号从1开始，n结束。
 *
 * p,q≤n≤100000 , 1≤ai,bi≤n , 数据保证所有的ai互相不相同，bi互相不相同。
 *
 * 输出描述
 * 输出包含三个数，只有A国想要的土地数，只有B国想要的土地数，两个国家都想要的土地数。
 *
 *
 * 样例输入
 * 5 3 3
 * 1 2 3
 * 3 4 5
 * 样例输出
 * 2 2 1
 *
 * 提示
 * 1,2号土地只有A想要，4,5号土地只有B想要，3号土地都想要
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] tudi = new int[n + 1];
        int sizeA = 0;
        int sizeB = 0;
        int sizeS = 0;
        for (int i = 0; i < p; i++) {
            sizeA++;
            tudi[sc.nextInt()]++;
        }
        for (int i = 0; i < q; i++) {
            int b = sc.nextInt();
            if (tudi[b] > 0) {
                sizeS++;
                sizeA--;
            } else {
                sizeB++;
            }
        }
        System.out.println(sizeA + " " + sizeB + " " + sizeS);
    }
}
