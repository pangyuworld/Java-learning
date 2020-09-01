package com.leetcode.p1103;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1103
 * @description:
 * @date 2020/3/5 8:55
 */
class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] persons = new int[num_people];
        if (num_people <= 1) {
            persons[0] = candies;
            return persons;
        }
        int personNum = num_people;
        int candiesNum = candies;
        int count = 0;
        int surplus = candies;
        // 这里得到了最终分完糖果的地方是从count*n的地方开始的，也就是第count圈
        while ((candiesNum = candiesNum - calculate(++count, personNum)) > 0) {
            surplus = candiesNum;
        }
        System.out.println(count);
        count--;
        int left = 1, right = num_people;
        int index = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

        }
        for (int i = 0; i < index; i++) {
            persons[i] += count * personNum + i;
        }
        count--;
        for (int i = count; i > 0; i++) {
            for (int j = 0; j < personNum; j++) {
                persons[j] += i * personNum + j;
            }
        }
        return persons;
    }

    /**
     * 高斯定理计算数列和
     *
     * @param n   数列开始的值
     * @param num 数列一共的数量
     * @return 数列和
     */
    private int calculate(int n, int num) {
        return (2 * n + num - 1) * num / 2;
    }

    public static void main(String[] args) {
        new Solution().distributeCandies(7, 4);
    }
}