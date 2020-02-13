package com.mianshi.first.no1;

import java.util.HashSet;
import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.first.no1
 * @description:
 * @date 2020/2/13 15:12
 */
public class Solution {
    public int minDeletionSize(String[] A) {
        char[][] str = new char[A.length][A[0].length()];
        for (int i = 0; i < A.length; i++) {
            str[i] = A[i].toCharArray();
        }
        int d = A[0].length();
        // 保存已经删除的列
        Set<Integer> deleteRow = new HashSet<>();
        for (int i = 0; i < A[0].toCharArray().length; i++) {
            for (int j = 0; j < A[i].length() - 1; j++) {
                if (str[i][j] > str[i][j + 1]) {
                    d--;
                    break;
                }
            }
        }
        return d;
    }
}
