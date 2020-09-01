package com.leetcode.p1116;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ZeroEvenOdd
 * @Package com.leecode.p1116
 * @description:
 * @date 2019/12/28 20:43
 */

/**
 * @author pang
 * @version V1.0
 * @ClassName: ZeroEvenOdd
 * @Package com.leecode.p1116
 * @description:
 * @date 2019/12/28 20:43
 */
class ZeroEvenOdd {
    private int n;
    private volatile int x;
    CountDownLatch latch0, latch1, latch2;

    public ZeroEvenOdd(int n) {
        latch0 = new CountDownLatch(1);
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(2);
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        latch0.countDown();
        while (x <= n) {
            latch0.await();
            printNumber.accept(0);
            latch1.countDown();
            latch2.countDown();
            latch0 = new CountDownLatch(1);
        }

    }

    /**
     * 输出偶数
     */
    public void even(IntConsumer printNumber) throws InterruptedException {

        while (x <= n) {

            latch2.await();
            if (x % 2 == 0)
                printNumber.accept(x++);
            latch1.countDown();
            latch0.countDown();
            latch2 = new CountDownLatch(2);
        }
    }

    /**
     * 输出奇数
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (x <= n) {
            latch1.await();
            if (x % 2 == 1)
                printNumber.accept(x++);
            latch2.countDown();
            latch0.countDown();
            latch1 = new CountDownLatch(2);
        }
    }
}
