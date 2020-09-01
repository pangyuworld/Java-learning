package com.pang.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AtomicTest
 * @Package com.pang.test
 * @description:
 * @date 2020/3/13 10:47
 */
public class AtomicTest{
    public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                num.addAndGet(10);
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                num.addAndGet(-11);
            }
        }).start();
        Thread.sleep(1000);
        System.out.println(num.get());
    }
}
