package com.pang.video;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestCompareAndSwap
 * @Package com.pang.video
 * @description: CAS 算法模拟
 * @date 2019/10/18 11:19
 */
@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
public class TestCompareAndSwap {
    public static void main(String...args){
        final CompareAndSwap cas=new CompareAndSwap();
        for (int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int ex=cas.get();
                    System.out.println(cas.compareAndSet(ex, (int) (Math.random() * 101)));
                }
            }).start();
        }
    }
}

class CompareAndSwap {
    private int value;

    // 获取内存值
    public synchronized int get() {
        return value;
    }

    // 比较
    public synchronized int compareAndSwap(int expectedValue, int newVale) {
        int oldValue = value;

        if (oldValue == expectedValue) {
            this.value = newVale;
        }
        return oldValue;
    }


    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}