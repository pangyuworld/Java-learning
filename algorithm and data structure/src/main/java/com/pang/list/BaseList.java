package com.pang.list;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseList
 * @Package com.pang.list.BaseList
 * @description: 链表基本操作(增删改查)的实现，参考《漫画算法》p33-p41
 * @date 2019/7/4 15:00
 */
public class BaseList<E> {
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
    public BaseList(E headElement) {
        // 新建头节点，值为参数
        this.head = new Node(headElement);
        // 没有执行操作时候，尾结点等于头结点
        this.last = this.head;
        // 链表实际长度初始化为1
        this.size = 1;
    }

    /**
     * 插入新的节点
     *
     * @param element 节点数据
     * @param index   节点位置
     * @return void
     * @author pang
     * @date 2019/7/4
     */
    public void insert(E element, int index) throws Exception {
        // 越界处理
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("超出链表");
        }
        if (index > 0 && index < this.size) {
            // 头部插入
            // 添加头结点副本
            Node headCopy = this.head;
            // 定义临时变量存储index前后的节点
            Node previousNode, nextNode;
            // 找到第index-1个节点
            for (int i = 0; i < index - 1; i++) {
                headCopy = headCopy.getNext();
            }
            // 储存上下节点的信息
            previousNode = headCopy;
            nextNode = headCopy.getNext();
            // 插入节点
            new Node(previousNode, element).setNext(nextNode);
        } else if (index == this.size) {
            // 尾部插入
            this.last = new Node(this.last, element);
        } else {
            // 头部插入
            this.head = new Node(element).setNext(this.head);
        }
        // 长度+1
        this.size++;
    }

    /**
     * 删除节点
     *
     * @param index 节点位置
     * @author pang
     * @date 2019/7/5
     */
    public void delete(int index) throws Exception {
        // 越界处理
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("超出链表");
        }
        if (index == 0) {
            // 头部删除
            this.head = this.head.getNext();
        } else if (index == this.size) {
            // 尾部删除
            // 创建头结点副本
            Node headCopy = this.head;
            // 找到倒数第二个节点
            for (int i = 0; i < this.size - 1; i++) {
                headCopy = headCopy.getNext();
            }
            // 将倒数第二个节点设置为空即为删除
            headCopy.setNext(null);
        } else {
            // 中部删除
            // 添加头结点副本
            Node headCopy = this.head;
            // 定义临时变量存储index前后的节点
            Node previousNode, nextNode;
            // 找到第index-1个节点
            for (int i = 0; i < index - 1; i++) {
                headCopy = headCopy.getNext();
            }
            // 储存上下节点的信息
            previousNode = headCopy;
            nextNode = headCopy.getNext();
            // 将第index-1个元素的next设置为第index+1即为删除
            previousNode.setNext(nextNode.getNext());
        }
        // 长度-1
        this.size--;
    }

    /**
     * 查询链表元素
     *
     * @param index 要查询的节点位置
     * @return int 节点数据
     * @author pang
     * @date 2019/7/5
     */
    public E get(int index) throws Exception {
        // 越界处理
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("超出链表");
        }
        if (index == this.size) {
            // 查询尾部
            return this.last.getData();
        } else {
            // 创建头结点副本
            Node headCopy = this.head;
            // 找到index个节点
            for (int i = 0; i < index; i++) {
                headCopy = headCopy.getNext();
            }
            return headCopy.getData();
        }
    }

    /**
     * 修改链表元素数据
     *
     * @param element 目标值
     * @param index   节点位置
     * @author pang
     * @date 2019/7/5
     */
    public void update(E element, int index) throws Exception {
        // 越界处理
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("超出链表");
        }
        if (index == this.size) {
            // 修改尾部
            this.last.setData(element);
        } else {
            // 创建头结点副本
            Node headCopy = this.head;
            // 找到index个节点
            for (int i = 0; i < index; i++) {
                headCopy = headCopy.getNext();
            }
            headCopy.setData(element);
        }
    }

    @Override
    public String toString() {
        String data = "";
        for (int i = 0; i < this.size; i++) {
            try {
                data += this.get(i) + ",";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "BaseList{[" + data + "],size=" + this.size + "}";
    }

    /**
     * 获得链表大小
     *
     * @return int 链表长度
     * @author pang
     * @date 2019/7/5
     */
    public int getSize() {
        return size;
    }


    /**
     * @author pang
     * @version V1.0
     * @ClassName: Node
     * @Package com.pang.list.BaseList.Node
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
        private E data;

        /**
         * 创建头结点
         *
         * @param element 节点数据
         * @author pang
         * @date 2019/7/5
         */
        public Node(E element) {
            this.data = element;
            this.next = null;
        }

        /**
         * 根据上一个节点创建节点
         *
         * @param previousNode 上一个节点
         * @param element      节点数据
         * @author pang
         * @date 2019/7/4
         */
        public Node(Node previousNode, E element) {
            previousNode.next = this;
            this.data = element;
        }

        /**
         * 获取下一个节点
         *
         * @return com.pang.list.BaseList.Node
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
         * @return com.pang.list.BaseList.Node
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
        public E getData() {
            return data;
        }

        /**
         * 设置当前节点数据大小
         *
         * @param data 数据
         * @return com.pang.list.BaseList.Node
         * @author pang
         * @date 2019/7/4
         */
        public Node setData(E data) {
            this.data = data;
            return this;
        }

    }

    /**
     * TEST
     */
    public static void main(String... args) throws Exception {
        // 新建一个大小为3的对象
        BaseList baseList = new BaseList(3);
        // 顺序插入2个元素，即尾部插入
        baseList.insert(5, 1);
        baseList.insert(9, 2);
        // 查看输入结果
        System.out.println("新建的对象：" + baseList);
        // 头部插入1个元素，即头部插入
        baseList.insert(99, 0);
        System.out.println("头部插入后：" + baseList);
        // 中部插入1个元素，即中部插入（同时执行扩容）
        baseList.insert(55, 1);
        System.out.println("中部插入后：" + baseList);
        // 读取元素
        for (int i = 0; i < baseList.getSize(); i++) {
            System.out.println("下标为" + i + "的元素，值为" + baseList.get(i));
        }
        // 修改元素
        baseList.update(100, 1);
        System.out.println("修改后的对象：" + baseList);
        // 删除元素
        baseList.delete(1);
        System.out.println("删除后的对象：" + baseList);
    }
}
