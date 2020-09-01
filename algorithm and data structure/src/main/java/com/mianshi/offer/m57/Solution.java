package com.mianshi.offer.m57;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m57
 * @description:
 * @date 2020/2/27 10:18
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        if (target <= 2) return new int[][]{};
        int l = 1, r = l + 1;
        List<int[]> list = new LinkedList<>();
        while (l < r) {
            if (sum(l, r) == target) {
                // 如果序列正好是目标值
                int[] a = new int[r - l + 1];
                int ll = l;
                for (int i = 0; i <= r - l; i++) {
                    a[i] = ll++;
                }
                list.add(a);
                l++;
                r++;
            } else if (sum(l, r) < target) {
                // 如果序列值小于目标值
                r++;
            } else if (sum(l, r) > target) {
                // 如果序列值大于目标值
                l++;
            }
            if (r >= target) {
                break;
            }
        }
        int[][] result = new int[0][];
        return list.toArray(result);
    }

    public int sum(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }
}