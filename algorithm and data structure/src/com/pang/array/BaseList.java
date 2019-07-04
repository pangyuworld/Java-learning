package com.pang.array;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseList
 * @Package com.pang.array.BaseList
 * @description: 链表基本操作(增删改查)的实现，参考《漫画算法》p33-p41
 * @date 2019/7/4 15:00
 */
public class BaseList {
    /**
     * 头结点指针
     */
    private Node head;
    /**
     * 尾结点指针
     */
    private Node last;
    /**
     * 链表实际长度
     */
    private int size;

    /**
     * 新建对象
     *
     * @param headElement 头结点数据值
     * @author pang
     * @date 2019/7/4
     */
    public BaseList(int headElement) {
        // 新建头节点，其next指针为null，值为参数
        this.head = new Node(null,headElement);
        // 没有执行操作时候，尾结点等于头结点
        this.last = this.head;
        // 链表实际长度初始化为1
        this.size = 1;
    }

    /**
     * 插入新的节点
     *
     * @param element 节点数据
     * @param index 节点位置
     * @return void
     * @author pang
     * @date 2019/7/4
     */
    public void insert(int element, int index) {
        // 越界处理
        if (index<0||index>this.size){
            throw new IndexOutOfBoundsException("超出链表");
        }
    }

    /**
     * @author pang
     * @version V1.0
     * @ClassName: Node
     * @Package com.pang.array.BaseList.Node
     * @description: 链表结构（单向）
     * @date 2019/7/4 15:00
     */
    public class Node {
        /**
         * 下一个节点
         */
        private Node next;
        /**
         * 节点数据
         */
        private int data;

        /**
         * 根据上一个节点创建节点
         *
         * @param previousNode 上一个节点
         * @param element 节点数据
         * @author pang
         * @date 2019/7/4
         */
        public Node(Node previousNode, int element) {
            previousNode.next = this;
            this.data = element;
        }

        /**
         * 获取下一个节点
         *
         * @return com.pang.array.BaseList.Node
         * @author pang
         * @date 2019/7/4
         */
        public Node getNext() {
            return next;
        }

        /**
         * 设置下一个节点
         *
         * @param next 下一个节点
         * @return com.pang.array.BaseList.Node
         * @author pang
         * @date 2019/7/4
         */
        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        /**
         * 获取当前节点数据
         *
         * @return int
         * @author pang
         * @date 2019/7/4
         */
        public int getData() {
            return data;
        }

        /**
         * 设置当前节点数据大小
         *
         * @param data 数据
         * @return com.pang.array.BaseList.Node
         * @author pang
         * @date 2019/7/4
         */
        public Node setData(int data) {
            this.data = data;
            return this;
        }
    }
}
