package com.pang.video;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestLock
 * @Package com.pang.video
 * @description: 同步锁
 * @date 2019/10/18 13:33
 * <p>
 * 1. 用于解决多线程安全问题方式:
 * 同步代码块 synchronized 隐式锁
 * 同步方法 synchronized 隐式锁
 * 同步锁（更灵活，jdk1.5以后） Lock
 * 注意：是一个显示锁，需要通过lock()方法上锁，必须通过unlock()方法进行释放锁
 */
public class TestLock {
    public static void main(String...args){
        Ticket ticket=new Ticket();

        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();
    }
}

class Ticket implements Runnable {
    private int tick = 100;

    private Lock lock =new ReentrantLock();

    @Override
    public void run() {

        while (tick > 0) {
            // lock.lock();
            try {
                Thread.sleep(20);
                if (tick>0) {
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为 " + --tick);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                // lock.unlock();
            }
        }
    }
}