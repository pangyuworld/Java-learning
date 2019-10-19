package com.pang.video;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestABCAlternate
 * @Package com.pang.video
 * @description: 编写一个程序，开启3个线程，三个线程的ID分别为 A B C ，然后每个线程按顺序打印自己的ID 10遍
 * @date 2019/10/18 14:11
 */
public class TestABCAlternate {

}

class AlternateDemo{
    /**
     * 当前正在执行线程的标记
     */
    private int number=1;

    private Lock lock=new ReentrantLock();

    private Condition condition=lock.newCondition();

    public void loopA(){

    }
}