package com.pang.video;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestScheduledThreadPool
 * @Package com.pang.video
 * @description: 线程调度
 * @date 2019/10/18 15:19
 */
public class TestScheduledThreadPool {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i=0;i<10;i++) {
            Future<Integer> future = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }
            }, 1, TimeUnit.SECONDS);
            System.out.println(future.get());
        }
        // 不shutdown的话，程序会一直运行
        pool.shutdown();
    }
}
