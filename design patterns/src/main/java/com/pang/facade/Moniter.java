package com.pang.facade;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Moniter
 * @Package com.pang.facade
 * @description:
 * @date 2019/10/11 14:21
 */
public class Moniter {
    private Moniter(){

    }
    private static Moniter moniter=new Moniter();
    public static Moniter getMoniter(){
        return moniter;
    }
    public void on() {
        System.out.println("显示器启动");
    }

    public void off() {
        System.out.println("显示器关闭");
    }
}
