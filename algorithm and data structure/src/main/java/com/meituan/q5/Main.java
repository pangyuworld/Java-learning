package com.meituan.q5;

import java.util.*;

/**
 * 题目描述：
 * 小团所在的班级今天去郊游了。小团的班级有n个人，每个人有一个独一无二的正整数学号ai。因为小团的班级很大（n可能达到10^9这么大！），点名成为了一个重大的问题。
 *
 * 小团作为班长，他想让同学们站成一列，他点名的方式如下：
 *
 * 1.如果当前点到的同学不在队列中，则加入队列中的第一个
 *
 * 2.如果当前点到的同学在队列中，则该同学出队，站到队列中第一个，并且不保留他之前的空位。
 *
 * 现在，给出小团的点名顺序，请你算出队列中同学是怎么排的。注意，点名可能存在重复，也可能只点名一部分同学。
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个整数m，表示小团点名了多少次。注意，n不会在输入中给出。
 *
 * 接下来m行，每行一个整数ai，代表小团每次点名的学号。
 *
 * 1≤m≤100000,n≤10^9
 *
 * 输出描述
 * 输出包含若干个整数，每个整数一行，第 i 行代表最后站在队列第 i 位同学的学号。
 *
 *
 * 样例输入
 * 3
 * 1
 * 2
 * 1
 * 样例输出
 * 1
 * 2
 *
 * 提示
 * 队列变化如下:
 * 1
 * 2 1
 * 1 2
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int m = sc.nextInt();
        Set<Student> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            Student student = new Student(sc.nextInt(), i);
            if (set.contains(student)){
                set.remove(student);
            }
            set.add(student);
        }
        List<Student> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student.id);
        }
    }

    static class Student implements Comparable {
        int id;
        int rank;

        public Student(int id, int rank) {
            this.id = id;
            this.rank = rank;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return id == student.id;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public int compareTo(Object o) {
            Student student = (Student) o;
            return this.rank > student.rank ? 1 : -1;
        }
    }
}
