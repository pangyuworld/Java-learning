package com.leetcode.p60;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static final int[] FACTORIAL = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

    public String getPermutation(int n, int k) {
        if (n == 0 || k > FACTORIAL[n] || k <= 0) {
            return "";
        }
        List<Integer> numberList = new ArrayList<>();
        // 保存所有数字
        for (int i = 0; i <= n; i++) {
            numberList.add(i);
        }
        StringBuffer sb = doSome(n, k, numberList, new StringBuffer());
        return sb.toString();
    }

    private StringBuffer doSome(int n, int k, List<Integer> numberList, StringBuffer numStr) {
        if (numberList.size() == 1) {
            return numStr;
        }
        int index = (k - 1) / FACTORIAL[n - 1] + 1;
        String str = String.valueOf(numberList.get(index));
        numberList.remove(index);
        numStr.append(str);
        int newK = k % FACTORIAL[n - 1];
        return doSome(n - 1, newK == 0 ? FACTORIAL[n - 1] : newK, numberList, numStr);
    }

    public static void main(String[] args) {
        // int sum =1;
        // for (int i = 1; i <= 10; i++) {
        //     sum*=i;
        //     System.out.println(i+":"+sum);
        // }
        // List<Integer> list = new ArrayList<>();
        // list.add(0);
        // list.add(1);
        // list.add(2);
        // System.out.println(list.get(1));
        // list.remove(1);
        // System.out.println(list.get(1));
        System.out.println(new Solution().getPermutation(9, 54494));
        System.out.println(new Solution().getPermutation(3, 2));
        System.out.println(new Solution().getPermutation(3, 3));
        System.out.println(new Solution().getPermutation(2, 2));
        System.out.println(new Solution().getPermutation(4, 9));
    }
}