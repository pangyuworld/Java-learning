package com.pang.test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestJoin
 * @Package com.pang.test
 * @description:
 * @date 2019/10/18 19:44
 */
public class TestJoin {
    public static void main(String...args){
        Thread td=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<10;i++){
                    System.out.println(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        td.start();
        try {
            td.join(2000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------");
    }
}
