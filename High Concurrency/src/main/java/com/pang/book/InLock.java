package com.pang.book;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pang
 * @version V1.0
 * @ClassName: InLock
 * @Package com.pang.book
 * @description: 重入锁中断
 * @date 2019/12/28 13:59
 */
public class InLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    /**
     * 控制加锁顺序，方便构造死锁
     */
    public InLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try{
            if (lock==1){
                /**
                 * {@link java.util.concurrent.locks.ReentrantLock} lockInterruptibly() 获得锁，但优先响应中断
                  */
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                lock2.lockInterruptibly();
            }else{
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                }
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if (lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId()+"线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        InLock r1=new InLock(1);
        InLock r2=new InLock(2);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        // 主动放弃对锁的申请
        t2.interrupt();
    }
}
