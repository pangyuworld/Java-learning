package com.leecode.p41;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p41
 * @description:
 * @date 2020/2/10 12:41
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {

        // 检查有没有1和将负数变为1
        boolean resultIsOne = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                resultIsOne = false;
            }
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        if (resultIsOne) return 1;

        // 将对应位置存在变为负数
        for (int i = 0; i < nums.length; i++) {
            int index=(nums[i]<0?nums[i]*-1:nums[i])-1;
            nums[index] = nums[index] < 0 ? nums[index] : nums[index] * -1;
        }
        // 找到第一个不为负数的下标
        int i=0;
        for (;i<nums.length;i++){
            if (nums[i]>0)break;
        }
        return i+1;
    }
}
