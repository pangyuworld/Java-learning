package com.pang.algorithm;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Test1
 * @Package com.pang.algorithm
 * @description: 判断单向链表有环
 * @date 2019/9/18 8:17
 */
public class Test1 {
    /**
     * 判断是否有环
     *
     * @param node 链表头结点
     * @return boolean
     * @author pang
     * @date 2019/9/18
     */
    public static boolean isCircle(Node node) {
        Node p1 = node, p2 = node;
        while (p2 != null && p2.getNext() != null) {
            // p1走一步
            p1 = p1.getNext();
            // p2走两步
            p2 = p2.getNext().getNext();
            // 如果p1等于p2发生了，那就有环
            if (p1.equals(p2)) {
                return true;
            }
        }
        // 如果循环可以结束，则没有坏
        return false;
    }

    /**
     * 获得环的长度
     *
     * @param node 头结点
     * @return int
     * @author pang
     * @date 2019/9/18
     */
    public static int getCircleLength(Node node) {
        Node p1 = node, p2 = node;
        int i1 = 0;
        boolean isFirst = true;
        while (p2 != null && p2.getNext() != null) {
            // p1走一步
            p1 = p1.getNext();
            i1 += 1;
            // p2走两步
            p2 = p2.getNext().getNext();
            // 如果p1等于p2发生了，那就有环
            if (p1.equals(p2)) {
                if (isFirst) {
                    isFirst = false;
                    i1 = 0;
                } else {
                    return i1;
                }
            }
        }
        return 0;
    }

    public static Node getFirstMeetNode(Node node) {
        Node p1 = node, p2 = node;
        boolean isFirst = true;
        while (p2 != null && p2.getNext() != null) {
            // p1走一步
            p1 = p1.getNext();
            // p2如果是第一次相遇前走两步，第一次相遇后走一步
            p2 = isFirst ? p2.getNext().getNext() : p2.getNext();
            // 如果p1等于p2发生了，那就有环
            if (p1.equals(p2)) {
                if (isFirst) {
                    isFirst = false;
                    // 让p1回到头结点
                    p1 = node;
                } else {
                    // 第二次相遇节点就是入口了
                    return p1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Node nodeA = new Node(5);
        Node nodeB = new Node(3);
        Node nodeC = new Node(7);
        Node nodeD = new Node(2);
        Node nodeE = new Node(6);
        Node nodeF = new Node(8);
        Node nodeG = new Node(1);
        // 做环
        nodeA.setNext(nodeB)
                .setNext(nodeC)
                .setNext(nodeD)
                .setNext(nodeE)
                .setNext(nodeF)
                .setNext(nodeG)
                .setNext(nodeD);
        System.out.println(isCircle(nodeA));
        System.out.println(getCircleLength(nodeA));
        System.out.println(getFirstMeetNode(nodeA));
    }

    /**
     * 构建一个简单的节点类
     */
    static class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public Node setNext(Node next) {
            this.next = next;
            return next;
        }

        public Node getNext() {
            return next;
        }

        public int getData() {
            return data;
        }

        public Node setData(int data) {
            this.data = data;
            return this;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
