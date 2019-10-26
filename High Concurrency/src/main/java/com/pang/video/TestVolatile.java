package com.pang.video;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestVolatile
 * @Package com.pang.video
 * @description: volatile 关键字视频例程
 * @date 2019/10/18 10:11
 * 内存可见性：当多个线程操作共享数据时候，彼此不可见
 * 大概是程序有个主存，然后每个线程都有自己的独立缓存，程序在线程中进行读写操作的时候，都要先从主存中获取数据，然后进行操作
 * 使用了volatile关键字，可以理解为所有的数据操作都是在主存中进行的
 */
public class TestVolatile {

    public static void main(String... args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        /**
         * while的执行效率特别高，导致主线程无法从主存中读取flag的改变后的值
         * 测试：如果添加一个sleep方法，就可以让主线程读取到flag的改变值了
         * 视频解决办法1：添加同步锁synchronized，同步锁可以保证数据及时的刷新，但是同步锁效率非常低
         * 视频解决办法2：volatile关键字，当多个线程进行操作共享数据是，可以保证内存中的数据可见，volatile比锁的效率高一点
         * synchronized与volatile的区别：
         *      volatile是一种较为轻量级的同步策略
         *      volatile不具备“互斥性”（互斥性：当一个线程占有锁的时候，其他线程不可以访问锁住的数据）
         *      volatile不能保证变量的“原子性”
         */
        while (true) {
            if (td.isFlag()) {
                System.out.println("--------------");
                break;
            }
        }
    }

}

class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag = " + isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public ThreadDemo setFlag(boolean flag) {
        this.flag = flag;
        return this;
    }
}