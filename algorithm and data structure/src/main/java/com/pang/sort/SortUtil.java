package com.pang.sort;

import com.pang.stack.BaseStack;

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
     * @author pang
     * @date 2019/9/10
     */
    public static void bubbleSortOptSecone(int[] array) {
        bubbleSortOptSecone(array, 0, array.length - 1);
    }

    /**
     * 鸡尾酒排序
     *
     * @param array 目标数组
     * @param left  左边界
     * @param right 右边界(注意是下标，而不是位置)
     * @author pang
     * @date 2019/9/13
     */
    public static void cocktailSort(int[] array, int left, int right) {
        // 初始化边界
        int low = left, high = right;
        // 左边界不要超过右边界即可
        while (low < high) {
            // 从左边界开始进行冒泡排序
            for (int i = low; i < high; i++) {
                if (array[i] > array[i + 1]) {
                    int cont = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = cont;
                }
            }
            // 右边界-1
            high--;
            // 从右边界开始进行反向冒泡排序
            for (int i = high; i > low; i--) {
                if (array[i] < array[i - 1]) {
                    int cont = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = cont;
                }
            }
            // 左边界+1
            low++;
        }
    }

    /**
     * 鸡尾酒排序
     *
     * @param array 目标数组
     * @author pang
     * @date 2019/9/13
     */
    public static void cocktailSort(int[] array) {
        cocktailSort(array, 0, array.length - 1);
    }

    /**
     * 快排（递归）
     *
     * @param array 目标数组
     * @param low   左边界
     * @param high  右边界
     * @return void
     * @author pang
     * @date 2019/9/17
     */
    public static void quickSort(int[] array, int low, int high) {
        // 如果左边界大于右边界
        if (low >= high) {
            return;
        }
        // 定义左右边界的临时变量
        int left = low, right = high;
        // 保存左边界的值
        int temp = array[low];
        // 循环条件就是左边界小于右边界
        while (left < right) {
            // 从右到左边找到一个比temp小的
            while (left < right && temp < array[right]) {
                right--;
            }
            // 如果找到了的话
            if (left < right) {
                // 让当前的左节点等于右节点
                array[left] = array[right];
                // 左边界+1
                left++;
            }
            // 从左到右知道一个比temp大的
            while (right > left && temp > array[left]) {
                left++;
            }
            // 如果找到了的话
            if (left < right) {
                // 让当前的右节点等于左节点
                array[right] = array[left];
                // 右边界-1
                right--;
            }
        }
        array[left] = temp;
        // 递归左边
        quickSort(array, low, left - 1);
        // 递归右边
        quickSort(array, left + 1, high);
    }

    /**
     * 快排递归版
     *
     * @param array 目标数组
     * @author pang
     * @date 2019/9/17
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     *  快排非递归实现
     * @author pang
     * @date 2019/9/17
     * @param array 目标数组
     * @param low 左边界
     * @param high 右边界
     */
    public static void quickSortByStatic(int[] array, int low, int high) {
        // 使用自己的栈,开二倍大小是因为左右的值都要存，如果是一倍的话，可能会出现爆栈情况
        BaseStack<Integer> stack = new BaseStack<>(array.length *2);
        // 把边界保存在栈中，注意，一定是先保存左边然后再保存右边
        stack.push(low);
        stack.push(high);
        while (!stack.isEmpty()) {
            // 只要栈不为空，循环还是可以进行下去的
            // 从栈中取出左右边界，注意入栈和出栈顺序
            // 定义temp是类似于递归里面的参数low和high
            int right = stack.pop(), rightTemp = right;
            int left = stack.pop(), leftTemp = left;
            // 如果左边大于右边那就可以停止本次循环了，如果是break可能会出现栈内含有元素的情况
            if (left >= right) {
                continue;
            }
            // 是的，下面直接复制快排的核心代码就可以了
            // 保存左边界的值
            int temp = array[left];
            // 循环条件就是左边界小于右边界
            while (left < right) {
                // 从右到左边找到一个比temp小的
                while (left < right && temp < array[right]) {
                    right--;
                }
                // 如果找到了的话
                if (left < right) {
                    // 让当前的左节点等于右节点
                    array[left] = array[right];
                    // 右边界-1
                    left++;
                }
                // 从左到右知道一个比temp大的
                while (right > left && temp > array[left]) {
                    left++;
                }
                // 如果找到了的话
                if (left < right) {
                    // 让当前的右节点等于左节点
                    array[right] = array[left];
                    // 左边界+1
                    right--;
                }
            }
            array[left] = temp;
            // 然后把需要递归的边界压入栈
            stack.push(left + 1);
            stack.push(rightTemp);
            stack.push(leftTemp);
            stack.push(left - 1);
        }
    }

    /**
     * 快排（非递归）
     *
     * @param array 目标数组
     * @author pang
     * @date 2019/9/17
     */
    public static void quickSortByStatic(int[] array) {
        quickSortByStatic(array, 0, array.length - 1);
    }

    public static void main(String... args) {
        int[] array = new int[10];
        int[] temp;
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        // array = new int[]{22, 68, 96, 43, 40, 18, 51, 7, 99, 18};
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
        System.out.println("鸡尾酒排序以后");
        temp = array.clone();
        cocktailSort(temp);
        print(temp);
        System.out.println("快速排序后");
        temp = array.clone();
        quickSort(temp);
        print(temp);
        System.out.println("快速（非递归）排序后");
        temp = array.clone();
        quickSortByStatic(temp);
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
