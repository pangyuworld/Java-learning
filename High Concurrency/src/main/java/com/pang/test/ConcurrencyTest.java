package com.pang.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ConcurrencyTest
 * @Package com.pang.test
 * @description:
 * @date 2019/10/19 9:54
 */
public class ConcurrencyTest implements Runnable {
    static volatile AtomicInteger cont = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            cont.getAndIncrement();
        }
    }

    public void getCont() {
        System.out.println(cont);
    }

    public static void main(String[] agrs) throws InterruptedException {
        new Thread(System.out::println).start();
        Thread.sleep(500);
        // ConcurrencyTest c1 = new ConcurrencyTest();
        // Thread t1 = new Thread(c1);
        // Thread t2 = new Thread(c1);
        // t1.start();
        // t2.start();
        // // 让主线程等待子线程完成
        // t1.join();
        // t2.join();
        // c1.getCont();
        Map map = new HashMap();
        Map map1 = new ConcurrentHashMap(map);
    }

}