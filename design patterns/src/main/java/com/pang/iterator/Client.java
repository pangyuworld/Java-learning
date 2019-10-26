package com.pang.iterator;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.iterator
 * @description:
 * @date 2019/10/26 14:32
 */
public class Client {
    public static void main(String[] args) {
        OrderList list=new OrderList();
        list.add("hello").add("world").add("ppp").add("sss").add("|dasd");
        Iterator iterator=list.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
