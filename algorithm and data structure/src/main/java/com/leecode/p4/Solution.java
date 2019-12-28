package com.leecode.p4;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p4
 * @description:
 * @date 2019/10/11 16:15
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // m和n为数组最大索引长度
        int m = nums1.length - 1;
        int n = nums2.length - 1;
        System.out.println(findI(nums1, nums2, 0, m));
        return 0.0;
    }

    /**
     * 寻找合适的i值
     *
     * @param nums1  数组1
     * @param nums2  数组2
     * @param mLeft  数组1的开始位置
     * @param mRight 数组1的结束位置
     */
    public double findI(int[] nums1, int[] nums2, int mLeft, int mRight) {
        // 如果左边界等于右边界，那就直接返回
        if (mLeft >= mRight) {
            // 这里要判断一些特殊情况
            // 定义j
            int j = ((nums1.length + nums2.length + 1) >> 1) - 1 - mLeft;
            // 如果i右边有值且小于j，则i+1
            if (mLeft < nums1.length - 1 && nums2[mLeft + 1] < nums2[j]) {
                mLeft++;
            }
            if ((nums1.length + nums2.length) % 2 == 0) {
                // 偶数情况
                return (nums1[mLeft] + nums2[j]) * 0.5;
            } else {
                // 奇数情况
                return Math.max(nums1[mLeft], nums2[j]);
            }
        }
        // i=(left+right0/2
        int i = ((mLeft + mRight) >> 1);
        // j=(数组1的最大索引长度+数组2的最大索引长度+1)/2-i
        int j = ((nums1.length + nums2.length + 1) >> 1) - 1 - i;
        // 判断是否符合条件
        // 数组1左边的最大值小于数组2右边的最小值，数组2左边的最大值小于数组1右边的最小值
        if (nums1[i - 1] < nums2[j] && nums2[j - 1] < nums1[i]) {
            return i;
        }
        // 不满足条件，分情况讨论
        // 如果nums1普遍小，num2普遍大，那么则要向右移动
        if (nums1[i] < nums2[j - 1]) {
            return findI(nums1, nums2, i + 1, mRight);
        }
        // 如果nums1普遍大，nums2普遍小，那么则要向左移动
        if (nums1[i - 1] > nums2[j]) {
            return findI(nums1, nums2, mLeft, i - 1);
        }
        return i;
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4};
        int[] b = {6, 7, 8, 9, 10,11};
        findMedianSortedArrays(a, b);

    }
}
