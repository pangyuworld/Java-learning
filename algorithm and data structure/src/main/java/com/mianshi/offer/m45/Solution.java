package com.mianshi.offer.m45;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.mianshi.offer.m45
 * @description:
 * @date 2020/2/27 10:46
 */
class Solution {
    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }
}
