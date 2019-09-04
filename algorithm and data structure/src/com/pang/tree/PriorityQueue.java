package com.pang.tree;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: PriorityQueue
 * @Package com.pang.tree
 * @description: 优先队列，这里用最小优先队列吧
 * @date 2019/9/3 18:18
 */
public class PriorityQueue<E> {
    /**
     * 二叉堆要用数组实现
     */
    private Node<E>[] array;
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
    public PriorityQueue(int maxArray) {
        this.maxArray = maxArray;
        array = new Node[maxArray];
        size = 0;
    }

    /**
     * 向二叉堆插入一条数据
     *
     * @param wegtht  权值
     * @param element 元素
     * @return void
     * @author pang
     * @date 2019/9/3
     */
    public PriorityQueue add(int wegtht, E element) {
        if (this.size >= this.maxArray) {
            throw new IndexOutOfBoundsException("二叉堆已满，无法插入数据");
        }
        // 创建一个临时变量储存下标
        int index = this.size;
        // 创建一个临时引用，方便交换
        Node node;
        // 然后把数据插入到叶子节点
        this.array[this.size++] = new Node<>(wegtht, element);
        // 然后下面就要根据权值来调整整个树结构
        while (this.array[index].getWeight() < this.array[this.getFatherNode(index)].getWeight()) {
            // 交换值
            node = this.array[index];
            this.array[index] = this.array[getFatherNode(index)];
            this.array[getFatherNode(index)] = node;
            // 然后下标也要变
            index = this.getFatherNode(index);
        }
        return this;
    }

    /**
     * 取出顶部元素
     *
     * @return E
     * @author pang
     * @date 2019/9/4
     */
    public E poll() {
        if (this.size <= 0) {
            throw new IndexOutOfBoundsException("二叉堆为空，无法删除数据");
        }
        // 把结果保存下来
        Node<E> result = this.array[0];
        // 删除堆顶元素然后让最后一个元素等于堆顶元素
        this.array[0] = this.array[this.size-- - 1];
        this.array[this.size] = null;
        // 一个下标的临时变量
        int index = 0;
        // 保存了左右节点的值，省的在写那么长的代码
        Node<E> left = this.array[this.getLeftNode(index)];
        Node<E> right = this.array[this.getRightNode(index)];
        // 这里的判断条件有点多，总结起来就是，不能越界，根节点大于某个子节点
        while (this.getRightNode(index) < this.maxArray &&
                this.array[index].getWeight() > left.getWeight() &&
                this.array[index].getWeight() > right.getWeight()) {
            left = this.array[this.getLeftNode(index)];
            right = this.array[this.getRightNode(index)];
            // 运行到这里就证明确实有个子节点比根节点小，那就拿最小的子节点吧
            if (left.getWeight() > right.getWeight()) {
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
        return result.getElement();
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
        return "PriorityQueue{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    /**
     * 自定义节点
     */
    private class Node<E> {
        /**
         * 权值
         */
        private int weight;
        /**
         * 元素
         */
        private E element;

        public int getWeight() {
            return weight;
        }

        public Node setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public E getElement() {
            return element;
        }

        public Node setElement(E element) {
            this.element = element;
            return this;
        }

        public Node(int weight, E element) {
            this.weight = weight;
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "weight=" + weight +
                    ", element=" + element +
                    '}';
        }
    }

    public static void main(String... args) {
        PriorityQueue<Integer> queue = new PriorityQueue(10);
        queue.add(2, 6)
                .add(6, 3)
                .add(3, 4)
                .add(4, 1)
                .add(9, 2)
                .add(1, 5)
                .add(8,7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
