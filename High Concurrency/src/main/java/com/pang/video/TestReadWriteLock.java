package com.pang.video;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestReadWriteLock
 * @Package com.pang.video
 * @description: 读写锁
 * @date 2019/10/18 14:26
 * 1. 读写锁使用情况
 *      多个线程同时在写的时候要使用读写锁
 *      多个线程同时又读又写时候要用读写锁
 *
 */
public class TestReadWriteLock {
    public static void main(String...args){
        final ReadWriteLockDemo rw=new ReadWriteLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                rw.set((int)(Math.random()*101));
            }
        },"Write").start();

        for (int i=0;i<100;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rw.get();
                }
            }).start();
        }
    }
}
class ReadWriteLockDemo{
    private int number=0;

    private ReadWriteLock lock=new ReentrantReadWriteLock();

    /**
     * 读
     */
    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : " + number);
        }finally {
            lock.readLock().unlock();
        }
    }
    /**
     * 写
     */
    public void set(int number){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}