package com.pang.tree;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BinaryHeap
 * @Package com.pang.tree
 * @description: 二叉堆的实现，完全是看书+自己理解，第一遍先不参考代码（这里先写最小堆）
 * @date 2019/9/3 15:53
 */
public class BinaryHeap {
    /**
     * 二叉堆要用数组实现
     */
    private int[] array;
    /**
     * 二叉堆最大的大小
     */
    private int maxArray;
    /**
     * 二叉堆当前大小
     */
    private int size;

    /**
     * 构建一棵空二叉树
     *
     * @param maxArray 二叉树最大值
     * @author pang
     * @date 2019/9/3
     */
    public BinaryHeap(int maxArray) {
        this.maxArray = maxArray;
        array = new int[maxArray];
        size = 0;
    }

    /**
     * 从数组构建一个二叉树，不能添加数据
     *
     * @param array 数组
     * @return
     * @author pang
     * @date 2019/9/3
     */
    public BinaryHeap(int[] array) {
        this(array.length);
        for (int i : array) {
            this.add(i);
        }
    }

    /**
     * 从数组构建一个二叉树且可自定义大小
     *
     * @param maxArray
     * @param array
     * @return
     * @author pang
     * @date 2019/9/4
     */
    public BinaryHeap(int maxArray, int[] array) {
        this(maxArray);
        for (int i : array) {
            this.add(i);
        }
    }

    /**
     * 向二叉堆插入一条数据
     *
     * @param data
     * @return void
     * @author pang
     * @date 2019/9/3
     */
    public BinaryHeap add(int data) {
        if (this.size >= this.maxArray) {
            throw new IndexOutOfBoundsException("二叉堆已满，无法插入数据");
        }
        // 这里创建一个下标是为了一会好运算最后的位置
        int index = this.size;
        // 如果二叉堆没有满，则将当前数据先插入到最后（即叶子节点）
        this.array[this.size++] = data;
        // 如果当前节点没有父节点大，那么就需要调整
        while (this.array[index] < this.array[this.getFatherNode(index)]) {
            // 下面一堆是两数交换的代码，使用位运算速度稍稍快一点
            this.array[index] = this.array[index] ^ this.array[this.getFatherNode(index)];
            this.array[this.getFatherNode(index)] = this.array[index] ^ this.array[this.getFatherNode(index)];
            this.array[index] = this.array[index] ^ this.array[this.getFatherNode(index)];
            // 然后下标也要变
            index = this.getFatherNode(index);
        }
        return this;
    }

    /**
     * 二叉堆删除堆顶元素，emmm，奇葩的设定
     *
     * @param
     * @return void
     * @author pang
     * @date 2019/9/3
     */
    public BinaryHeap delete() {
        if (this.size <= 0) {
            throw new IndexOutOfBoundsException("二叉堆为空，无法删除数据");
        }
        // 删除堆顶元素然后让最后一个元素等于堆顶元素
        this.array[0] = this.array[this.size-- - 1];
        this.array[this.size] = 0;
        // 这里初始化一个下标是因为变量好用
        int index = 0;
        // 保存了左右节点的值，省的在写那么长的代码
        int left = this.array[this.getLeftNode(index)];
        int right = this.array[this.getRightNode(index)];
        // 这里的判断条件有点多，总结起来就是，不能越界，根节点大于某个子节点
        while (this.getRightNode(index) < this.maxArray &&
                this.array[index] > left &&
                this.array[index] > right) {
            left = this.array[this.getLeftNode(index)];
            right = this.array[this.getRightNode(index)];
            // 运行到这里就证明确实有个子节点比根节点小，那就拿最小的子节点吧
            if (left > right) {
                // 左边比右边大的情况
                // 交换数值
                this.array[this.getRightNode(index)] = this.array[index];
                this.array[index] = right;
                // 下标变换
                index = this.getRightNode(index);
            } else {
                // 左边比右边小的情况
                this.array[this.getLeftNode(index)] = this.array[index];
                this.array[index] = left;
                // 下标变换
                index = this.getLeftNode(index);
            }
        }
        return this;
    }

    /**
     * 根据节点信息获取父节点位置
     *
     * @param index 子节点位置
     * @return int
     * @author pang
     * @date 2019/9/3
     */
    private int getFatherNode(int index) {
        return index / 2;
    }

    /**
     * 获取左子节点位置
     *
     * @param index 父节点位置
     * @return int
     * @author pang
     * @date 2019/9/3
     */
    private int getLeftNode(int index) {
        return (index + 1) * 2 - 1;
    }

    /**
     * 获取右子节点的位置
     *
     * @param index 父节点位置
     * @return int
     * @author pang
     * @date 2019/9/3
     */
    private int getRightNode(int index) {
        return (index + 1) * 2;
    }


    @Override
    public String toString() {
        return "BinaryHeap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String... args) {
        BinaryHeap heap = new BinaryHeap(10);
        heap.add(10)
                .add(9)
                .add(8)
                .add(7)
                .add(6)
                .add(5)
                .add(4)
                .add(3)
                .add(2)
                .add(1);
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        // 下面这里出了问题，等待排查
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
        heap.delete();
        System.out.println(heap);
    }
}
