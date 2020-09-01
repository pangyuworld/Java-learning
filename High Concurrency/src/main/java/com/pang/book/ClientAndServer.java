package com.pang.book;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ClientAndServer
 * @Package com.pang.book
 * @description: 客户端和服务器模式
 * @date 2019/12/28 13:24
 */
public class ClientAndServer {
    private volatile static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number=42;
        ready=true;
        Thread.sleep(10000);
    }
}
