package com.pang.video;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestThreadPool
 * @Package com.pang.video
 * @description: 线程池
 * @date 2019/10/18 14:51
 * 1. 为什么要用线程池
 * 2. 线程池提供了一个线程队列，队列中保存着所有等待状态的线程。避免了创建于销毁线程额外开销，提高了相应的速度。
 * 3. 线程池的体系结构
 *    @see java.util.concurrent.Executor 负责线程的使用与调度的根接口
 *          |-- ExecutorService 子接口：线程池的主要接口
 *              |-- ThreadPoolExecutor 实现类.
 *              |-- ScheduledExecutorService 子接口：负责线程的调度
 *                  |-- ScheduledThreadPoolExecutor 继承了ThreadPoolExecutor，实现了ScheduledExecutorService接口
 * 4. 需要使用 {@link java.util.concurrent.Executors} 即线程池工厂创建线程池
 *      ExecutorService newFixedThreadPool(int nThreads) 创建固定大小的线程池
 *      ExecutorService newCachedThreadPool() 缓存线程池，线程池的数量不固定，可以根据需求自动的更改数量
 *      ExecutorService newSingleThreadExecutor() 创建单个线程池，线程池中只有一个线程
 *
 *      ScheduledExecutorService newScheduledThreadPool() 创建固定大小的线程，可以延迟或定时执行任务
 *
 */
public class TestThreadPool {
    public static void main(String...args){
        //noinspection AlibabaThreadPoolCreation
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 为线程池中的线程分配任务
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                }
            }
        });executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                }
            }
        });executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                }
            }
        });
        // 关闭线程池
        executorService.shutdown();
    }
}
class ThreadPoolDemo implements Runnable{

    @Override
    public void run() {

    }
}