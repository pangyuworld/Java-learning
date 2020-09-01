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
     * 二叉堆取出并删除堆顶元素 这里卡住了，很久很久，因为不知道逻辑怎么写，看书也没看到 为什么卡住了，是因为再循环处的判断条件我想的过多，比如首先不是叶子结点，然后有无右子节点，左右子节点哪个比较小，还有最重要的是
     * 如何遏制数组越界问题。 当然，最后还是解决了，大概思路就是只要有左子节点就不是叶子节点，然后再判断有无右子节点，有的话判断大小 然后如果右子节点比较小，那就和右子节点互换 如果右子节点比较大，
     * 那就相当于没有右子节点，直接比较左子节点就就好了。
     *
     * @return void
     * @author pang
     * @date 2019/9/3
     */
    public int poll() {
        if (this.size <= 0) {
            throw new IndexOutOfBoundsException("二叉堆为空，无法删除数据");
        }
        int result = this.array[0];
        // 删除堆顶元素然后让最后一个元素等于堆顶元素
        this.array[0] = this.array[this.size-- - 1];
        this.array[this.size] = 0;
        // 这里初始化一个下标是因为变量好用
        int index = 0;
        // 只要有左子节点，就证明了不是根节点
        while (getLeftNode(index) < this.size && this.array[getLeftNode(index)] > 0) {
            if (getRightNode(index) < this.size
                    && this.array[getRightNode(index)] > 0
                    && this.array[getLeftNode(index)] > this.array[getRightNode(index)]) {
                // 如果有右子节点且右子节点比左子节点小
                if (this.array[getRightNode(index)] < this.array[index]) {
                    // 然后比较根节点和右子节点，如果右子节点比根节点小，则互换
                    int temp = this.array[getRightNode(index)];
                    this.array[getRightNode(index)] = this.array[index];
                    this.array[index] = temp;
                    // 互换下标
                    index = this.getRightNode(index);
                    // 停止本层循环
                    continue;
                }
            }
            // 没有右子节点，那就比较左子节点
            if (this.array[getLeftNode(index)] < this.array[index]) {
                // 然后比较根节点和右子节点，如果右子节点比根节点小，则互换
                int temp = this.array[getLeftNode(index)];
                this.array[getLeftNode(index)] = this.array[index];
                this.array[index] = temp;
                // 互换下标
                index = this.getLeftNode(index);
                continue;
            }
            // 如果根节点不小于左右子节点，则停止循环
            break;
        }
        return result;
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
        return (index - 1) / 2;
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
        return index * 2 + 1;
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
        return index * 2 + 2;
    }

    /**
     * 判断是否是叶子节点
     *
     * @return boolean
     * @author pang
     * @date 2019/9/5
     */
    private boolean isLeafNode(int index) {
        if (this.getLeftNode(index) > this.maxArray || this.getRightNode(index) > this.maxArray) {
            return true;
        } else if (this.array[this.getLeftNode(index)] == 0 && this.array[this.getRightNode(index)] == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String... args) {
        BinaryHeap heap = new BinaryHeap(10);
        heap.add(1)
                .add(4)
                .add(5)
                .add(1)
                .add(3)
                .add(4)
                .add(2)
                .add(6);
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        // 下面这里出了问题，等待排查
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        System.out.println(heap.poll());
        System.out.println(heap);
        heap.poll();
        System.out.println(heap);
    }
}
