package com.pang.video;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestThread8Monitor
 * @Package com.pang.video
 * @description: 线程八锁（工作当中常见的8中情况）
 * @date 2019/10/18 14:36
 * 题目：判断打印的是 one 还是 two
 * 1. 两个普通同步方法，两个线程标准打印，打印的是什么？  one  two
 * 2. 新增 Thread.sleep() 给getOne() ？  one two
 * 3. 新增普通方法 getThree，打印？ three one two
 * 4. 两个普通的同步方法，两个Number对象，打印？ two one
 * 5. 修改getOne()为静态同步方法，打印？ two one
 * 6. 修改两个方法均为静态同步方法，一个Number对象？ one two
 * 7. 一个是静态同步方法，一个是费静态同步方法，两个Number对象？ two one
 * 8. 两个静态同步方法，两个Number对象？ one two
 * 结论：在某一时刻，只有一个对象能持有锁，其他线程不能抢占锁
 * 关键：1. 非静态方法的锁默认为：this  静态方法的锁对应为Class实例
 * 2. 某一时刻只能有1个线程持有锁，无论几个方法
 */
public class TestThread8Monitor {
    public static void main(String... args) {
        final Number number = new Number();
        final Number number1 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number1.getTwo();
                // number.getTwo();
            }
        }).start();

        // new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         number.getThree();
        //     }
        // }).start();
    }
}

class Number {
    public static synchronized void getOne() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree() {
        System.out.println("three");
    }
}