package com.pang.sort;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: SortUtil
 * @Package com.pang.sort
 * @description: 排序算法类，包含了各种排序
 * @date 2019/9/10 10:19
 */
public class SortUtil {

    /**
     * 冒泡排序
     *
     * @param array 目标数组
     * @param left  左边界
     * @param right 右边界(注意是下标，而不是位置)
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSort(int array[], int left, int right) {
        for (int i = left; i <= right; i++) {
            for (int j = left; j <= right - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int cont = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = cont;
                }
            }
        }
    }

    /**
     * 冒泡排序
     *
     * @param array 目标数组
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSort(int[] array) {
        bubbleSort(array, 0, array.length - 1);
    }

    /**
     * 冒泡排序优化第一步，如果目标数组末尾元素已经排序了则停止排序
     *
     * @param array 目标数组
     * @param left  左边界
     * @param right 右边界(注意是下标，而不是位置)
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSortOptFirst(int[] array, int left, int right) {
        // 添加一个标记，标记后面的数组是否已经排序
        boolean isSorted = true;
        for (int i = left; i <= right; i++) {
            isSorted = true;
            for (int j = left; j <= right - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int cont = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = cont;
                    // 如果有进行交换就证明可能存在未排序的元素
                    isSorted = false;
                }
            }
            // 如果后面的元素已经排序，则停止循环
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序优化第一步
     *
     * @param array 目标数组
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSortOptFirst(int[] array) {
        bubbleSortOptFirst(array, 0, array.length - 1);
    }

    /**
     * 冒泡排序第二部优化
     *
     * @param array 目标数组
     * @param left  左边界
     * @param right 右边界(注意是下标，而不是位置)
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSortOptSecone(int[] array, int left, int right) {
        // 添加一个标记，标记后面的数组是否已经排序
        boolean isSorted = true;
        // 无序标记，
        int sortBorder = right;
        int lastExchangeIndex = right;
        for (int i = left; i <= right; i++) {
            isSorted = true;
            for (int j = left; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int cont = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = cont;
                    // 如果有进行交换就证明可能存在未排序的元素
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            // 如果后面的元素已经排序，则停止循环
            if (isSorted) {
                break;
            }
        }
    }

    /**
     * 冒泡排序第二部优化
     *
     * @param array
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSortOptSecone(int[] array) {
        bubbleSortOptSecone(array, 0, array.length - 1);
    }

    public static void main(String... args) {
        int[] array = new int[10];
        int[] temp = array.clone();
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        System.out.println("原数组");
        temp = array.clone();
        print(temp);
        System.out.println("冒泡排序后");
        temp = array.clone();
        bubbleSort(temp);
        print(temp);
        System.out.println("冒泡排序第一步优化以后");
        temp = array.clone();
        bubbleSortOptFirst(temp);
        print(temp);
        System.out.println("冒泡排序第二步优化以后");
        temp = array.clone();
        bubbleSortOptSecone(temp);
        print(temp);
        System.out.println("标准答案");
        temp = array.clone();
        Arrays.sort(temp);
        print(temp);
    }

    /**
     * 输出数组，因为太麻烦了，所以写个函数方便一些
     *
     * @param array
     * @return void
     * @author pang
     * @date 2019/9/10
     */
    public static void print(int[] array) {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
