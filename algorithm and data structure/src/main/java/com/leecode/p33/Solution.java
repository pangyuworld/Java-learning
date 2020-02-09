package com.leecode.p33;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p33
 * @description:
 * @date 2020/2/9 14:50
 */
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length<1)return -1;
        // 第一步，判断前半部分是不是升序
        int left = 0;
        int right = nums.length - 1;
        // 判断左半部分是否无序
        boolean leftSort = judgeLeftSort(nums, left, right);
        // 查找目标
        return findTarget(nums, leftSort, left, right, target);
    }

    private int findTarget(int[] nums, boolean leftSort, int left, int right, int target) {
        int mid = (left + right) / 2;// 中间坐标
        int midValue = nums[mid];// 中间值
        if (midValue == target) return mid;// 如果找到了目标，那就返回这个坐标
        if (left<right) {
            if (leftSort) {
                // 如果左半部分有序
                if (target >= nums[left] && target < nums[mid]) {
                    // 确认能够在左半部分查到,则递归查询
                    return findTarget(nums, true, left, mid, target);
                } else {
                    // 不能再有序部分查到,那就递归深入
                    return findTarget(nums, judgeLeftSort(nums, mid + 1, right), mid + 1, right, target);
                }
            } else {
                // 如果右半部分有序
                if (target <= nums[right] && target > nums[mid]) {
                    // 确认在右半部分能够查到
                    return findTarget(nums, true, mid + 1, right, target);
                } else {
                    // 不能确认在有序部分查到
                    return findTarget(nums, judgeLeftSort(nums, left, mid), left, mid, target);
                }
            }
        }else{
            return -1;// 如果没有找到，那就返回-1；
        }
    }

    private boolean judgeLeftSort(int[] nums, int left, int right) {
        return nums[(left + right) / 2] >= nums[left];
    }

    public static void main(String[] args) {
        new Solution().search(new int[]{3,1},1);
    }
}