package com.mianshi.offer.m20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/2 9:07 godspeed.zxy Exp $
 */
class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().isNumber("1 "));

        System.out.println(Double.parseDouble(" .1"));
    }

    public static final Set<Character> FIRST_CHAR = new HashSet<>(Arrays.asList('+', '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','e','.'));
    static boolean havePoint = false;

    public boolean isNumber(String s) {
        s = s.trim();
        for (char c : s.toCharArray()) {
            if (!FIRST_CHAR.contains(c)) {
                return false;
            }
        }
        try {
            Double.parseDouble(s);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean isFraction(String num) {
        if (!judgeHead(num)) {
            return false;
        }
        havePoint = false;
        char[] chars = num.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '.') {
                if (havePoint) {
                    return false;
                }
                havePoint = true;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean judgeHead(String num) {
        char c = num.charAt(0);
        if (c=='.'){
            return true;
        }
        return FIRST_CHAR.contains(c);
    }
}