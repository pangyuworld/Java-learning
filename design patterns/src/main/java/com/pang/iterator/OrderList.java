package com.pang.iterator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: OrderList
 * @Package com.pang.iterator
 * @description:
 * @date 2019/10/26 14:28
 */
public class OrderList implements Iterable {
    @Override
    public Iterator getIterator() {
        return new OrderIterator();
    }

    private List<String> orders;

    public OrderList() {
        orders = new LinkedList<>();
    }

    public OrderList add(String orderName) {
        orders.add(orderName);
        return this;
    }

    private class OrderIterator implements Iterator {

        private int position = -1;

        @Override
        public boolean hasNext() {
            return ++position < orders.size();
        }

        @Override
        public Object next() {
            return orders.get(position);
        }
    }
}
