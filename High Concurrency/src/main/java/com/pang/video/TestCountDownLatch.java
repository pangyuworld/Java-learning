package com.pang.video;

import java.util.concurrent.CountDownLatch;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestCountDownLatch
 * @Package com.pang.video
 * @description: 闭锁
 * @date 2019/10/18 12:21
 * 闭锁：在完成某些运算时候，只有其他所有的运算全部完成，当前运算才继续执行
 * 例：计算代码执行时间
 * 闭锁操作笔记：
 *      1. new CountDownLatch(int count);这里的count参数是线程需要等待的次数，后面还会对这个count进行操作，只有当count为0的时候，程序才能往下进行
 *      2. 执行完操作以后调用 CountDownLatch的countDown()方法让上面的count-1
 *      3. 主线程使用 CountDownLatch的countDown的await()方法进行挂起，这里就是如果count大于0，那就一直挂起（可以尝试开辟4个线程）
 */
public class TestCountDownLatch {
    public static void main(String... args) {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo ld = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            new Thread(ld).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        System.out.println("运行时间："+(end-start));
    }
}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                // 闭锁-1
                latch.countDown();
            }
        }
    }
}