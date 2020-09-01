package com.pang.book;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: HashMapMultiThread
 * @Package com.pang.book
 * @description: hashMap并发问题
 * @date 2019/12/28 13:42
 */
public class HashMapMultiThread {
    static Map<String,String> map=new HashMap<>();

    public static class AddThread implements Runnable{
        int start=0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i++) {
                map.put(""+i,""+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new HashMapMultiThread.AddThread(0));
        Thread t2=new Thread(new HashMapMultiThread.AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
