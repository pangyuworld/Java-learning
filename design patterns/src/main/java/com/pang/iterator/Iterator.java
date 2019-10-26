package com.pang.iterator;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Iterator
 * @Package com.pang.iterator
 * @description: 迭代器
 * @date 2019/10/26 14:24
 */
public interface Iterator<E> {
    public boolean hasNext();
    public E next();
}
