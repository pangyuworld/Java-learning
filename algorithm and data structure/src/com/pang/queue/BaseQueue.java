package com.pang.queue;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseQueue
 * @Package com.pang.queue
 * @description: 队列的基本操作，这里仅仅是最基础的先进先出队列
 * @date 2019/7/12 20:09
 */
public class BaseQueue<E> {
    /**
     * 储存散列表的容器
     */
    private Object[] queue;
    /**
     * 队列首的位置
     */
    private int head;
    /**
     * 队列尾的位置
     */
    private int tail;
    /**
     * 队列的最大容量
     */
    private int size;

    public BaseQueue(int queueSize) {
        this.size = queueSize+1;
        this.queue = new Object[this.size];
        tail = 0;
        head = 0;
    }

    /**
     * 向队列插入元素
     *
     * @param element 插入的元素
     * @author pang
     * @date 2019/7/12
     */
    public void add(E element) throws Exception {
        int realTail = this.tail % this.size;
        int realHead = this.head % this.size;
        // 如果队列满了，这里注意不用realTail是因为有可能realTail是最后一个位置
        if ((this.tail + 1) % this.size == realHead) {
            throw new IndexOutOfBoundsException("向队列添加元素时候超出队列容量");
        }
        // 插入元素
        this.queue[realTail] = element;
        // 尾部指针+1
        this.tail++;
    }

    /**
     * 取出队列头部元素
     *
     * @return E 队列头部元素
     * @author pang
     * @date 2019/7/12
     */
    public E poll() {
        int realTail = this.tail % this.size;
        int realHead = this.head % this.size;
        // 如果队列为空，这里注意不用realHead是因为有可能realHead是最后一个位置
        if ((this.head ) % this.size == realTail) {
            throw new IndexOutOfBoundsException("从队列取出元素时候元素为空");
        }
        // 头部指针+1
        this.head++;
        // 返回元素
        return (E) this.queue[realHead];
    }

    /**
     * 判断是否为空
     *
     * @return boolean
     * @author pang
     * @date 2019/9/3
     */
    public boolean isEmpty() {
        if ((this.head ) % this.size == this.tail % this.size) {
            return true;
        }
        return false;
    }

    public static void main(String ... args) throws Exception {
        BaseQueue queue=new BaseQueue(1);
        queue.add(2);
        System.out.println(queue.poll());
    }
}
