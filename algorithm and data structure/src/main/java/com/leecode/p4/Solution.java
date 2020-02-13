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
        int m = nums1.length, n = nums2.length;
        // 寻找第k小的数字
        int k = (m + n) / 2;

        return 0.0;
    }


    @Test
    public void test() {
        int[] a = {1, 2, 3, 4};
        int[] b = {6, 7, 8, 9, 10, 11};
        findMedianSortedArrays(a, b);

    }
}
