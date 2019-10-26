package com.pang.iterator;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Iterable
 * @Package com.pang.iterator
 * @description: 允许迭代器
 * @date 2019/10/26 14:24
 */
public interface Iterable<E> {
    public Iterator<E> getIterator();
}
