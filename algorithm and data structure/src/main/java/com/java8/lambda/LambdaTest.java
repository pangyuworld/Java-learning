package com.java8.lambda;

/**
 * @author pang
 * @version V1.0
 * @ClassName: LambdaTest
 * @Package com.java8.lambda
 * @description:
 * @date 2019/10/22 12:50
 */
public class LambdaTest {
    public static void main(String[] args) {
        Runnable a = () -> System.out.println("hello world");
        new Thread(a).start();
        StringBuffer s;
        StringBuilder ss;
        String sss;
    }
}
