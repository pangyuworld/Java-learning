package com.leetcode.p7;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p7
 * @description: 整数反转 https://leetcode-cn.com/problems/reverse-integer/
 * @date 2019/12/28 21:05
 */
class Solution {
    public int reverse(int x) {
        long s=x;
        long result=0;
        while (s!=0){
            long d=s%10;
            result=result*10+d;
            s/=10;
        }
        if (result>Integer.MAX_VALUE||result<Integer.MIN_VALUE){
            return 0;
        }
        return (int) result;
    }

    @Test
    public void test() {
        System.out.println(this.reverse(1463847412));
    }
}