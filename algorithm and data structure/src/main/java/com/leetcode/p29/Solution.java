package com.leetcode.p29;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p29
 * @description:
 * @date 2020/2/13 13:38
 */
class Solution {
    int result;

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        if (dividend == 0) return 0;
        boolean isF = false;
        // 如果是符号不一样，那就全部转为负数
        if (dividend < 0 && divisor > 0) {
            isF = true;
            divisor = -divisor;
        } else if (dividend > 0 && divisor < 0) {
            isF = true;
            dividend = -dividend;
        } else if (dividend > 0 && divisor > 0) {
            isF = false;
            dividend = -dividend;
            divisor = -divisor;
        }
        // 如果符号一样，那正负无所畏了
        result = 0; // 结果
        int temp = divisor; // 除数的临时样本
        getResult(dividend, divisor, temp);
        return isF ? -result : result;
    }

    private void getResult(int dividend, int divisor, int temp) {
        if (dividend > divisor) return;
        int i = 1;// 当前扩充了多少倍
        while (true) {
            dividend = dividend - divisor;
            if (dividend < 0) {
                result += i;
            } else if (dividend == 0) {
                result += i;
                return;
            } else {
                // 如果计算结果小0了
                // 那就重新计算余数的结果
                getResult(divisor + dividend, temp, temp);
                break;
            }
            i++;
            divisor = divisor + divisor;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Solution().divide(Integer.MAX_VALUE, 1));
        System.out.println(System.currentTimeMillis() - start);
    }
}