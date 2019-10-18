package com.pang.observer;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.observer
 * @description:
 * @date 2019/10/17 15:47
 */
public class Client {
    public static void main(String...args){
        RingEvent event=new RingEvent();
        event.addObserver(new Student("张三"));
        event.addObserver(new Student("李四"));
        event.addObserver(new Student("王五"));
        event.addObserver(new Teacher("陈老师"));

        event.ringAfterClass();

        event.ringBeforeClass();
    }
}
