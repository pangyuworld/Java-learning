package com.pang.video;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestAtomicDemo
 * @Package com.pang.video
 * @description: 原子性视频例程
 * @date 2019/10/18 10:54
 *
 * 1. i++原子性问题，i++的操作实际上分为三个步骤：读-改-写
 *      因为i++ 有三步操作，所以不能使用volatile修饰，因此可以理解为volatile只能保证一条语句正常执行
 * 2. 原子变量：jdk1.5以后，java.util.concurrent.atomic包下提供了大量原子变量
 *      这个包下面的数据都是使用了volatile修饰的，保证了内存可见性
 *      CAS （Compare-And-Swap）算法保证了数据的原子性(CAS详情可见《深入理解Java虚拟机》p394)
 *          CAS 算法是硬件对于并发操作共享数据的支持
 *          CAS 包含了三个操作数：
 *              内存值 V
 *              预估值 A
 *              更新至 B
 *              当且仅当 V == A 的时候， V = B ，否则不进行任何操作
 */
public class TestAtomicDemo {
    public static void main(String...args){
        AtomicDemo ad=new AtomicDemo();
        for (int i=0;i<10;i++){
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable{
    // private int serialNumber= 0 ;

    private AtomicInteger serialNumber=new AtomicInteger(0);
    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
    }
    public int getSerialNumber(){
        return serialNumber.getAndIncrement();
    }
}