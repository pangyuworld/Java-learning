package com.leecode.p9;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p9
 * @description:
 * @date 2020/2/12 12:45
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;
        if (x % 10 == 0) return false;
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x = x / 10;
            if (result == x) return true;
        }
        return x == result / 10;
    }
}