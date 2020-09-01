package com.leetcode.p1115;

import java.util.concurrent.CountDownLatch;

/**
 * @author pang
 * @version V1.0
 * @ClassName: FooBar
 * @Package com.leecode.p1115
 * @description:
 * @date 2019/12/28 20:09
 */
class FooBar {
    CountDownLatch latch1 = new CountDownLatch(1), latch2 = new CountDownLatch(2);
    private int n;
    volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
            latch1.countDown();
            latch2.countDown();
        for (int i = 0; i < n; i++) {
            latch1.await();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            latch1 = new CountDownLatch(1);
            latch2.countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            latch2.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            latch2=new CountDownLatch(1);
            latch1.countDown();
        }
    }
}