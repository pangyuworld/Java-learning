package com.pang.stack;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseStack
 * @Package com.pang.stack
 * @description: 链表基本操作(增删改查)的实现，参考《漫画算法》p43-p45
 * @date 2019/7/5 11:27
 */
public class BaseStack<E> {
    /**
     * 栈容器
     */
    private Object[] stack;
    /**
     * 栈当前容量
     */
    private int size;

    /**
     * 构建一个栈对象
     *
     * @param stackSize 栈大小
     * @author pang
     * @date 2019/7/5
     */
    public BaseStack(int stackSize) {
        this.size = 0;
        this.stack = new Object[stackSize];
    }

    /**
     * 出栈
     *
     * @return int 栈顶元素
     * @author pang
     * @date 2019/7/5
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        // 空栈异常处理
        if (this.size <= 0) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        // 得到栈顶元素且size-1
        return (E) this.stack[(this.size--) - 1];
    }

    /**
     * 仅仅是获得栈顶元素的值，不删除栈顶元素
     *
     * @return E
     * @author pang
     * @date 2019/9/2
     */
    public E top() {
        // 空栈异常处理
        if (this.size <= 0) {
            throw new IndexOutOfBoundsException("栈为空");
        }
        // 得到栈顶元素且size-1
        return (E) this.stack[this.size - 1];
    }

    /**
     * 入栈
     *
     * @param element 入栈元素
     * @author pang
     * @date 2019/7/5
     */
    public void push(E element) {
        // 爆栈处理
        if (this.size >= this.stack.length) {
            throw new IndexOutOfBoundsException("栈为满");
        }
        // 入栈操作
        this.stack[(++this.size) - 1] = element;
    }

    /**
     * 判断栈是否为空
     *
     * @return boolean
     * @author pang
     * @date 2019/9/2
     */
    public boolean isEmpty() {
        if (this.size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获得栈大小
     *
     * @return int 栈大小
     * @author pang
     * @date 2019/7/5
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "BaseStack{" +
                "stack=" + Arrays.toString(stack) +
                ", size=" + size +
                '}';
    }

    /**
     * TEST
     */
    public static void main(String... args) {
        BaseStack baseStack = new BaseStack(3);
        System.out.println(baseStack);
        baseStack.push(2);
        System.out.println(baseStack);
        baseStack.push(3);
        System.out.println(baseStack);
        baseStack.push(1);
        System.out.println(baseStack);
        baseStack.pop();
        System.out.println(baseStack);
        baseStack.pop();
        System.out.println(baseStack);
        baseStack.pop();
        System.out.println(baseStack);
    }
}
