package com.pang.facade;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Disk
 * @Package com.pang.facade
 * @description:
 * @date 2019/10/11 14:21
 */
public class Disk {
    private Disk(){

    }
    private static Disk disk=new Disk();
    public static Disk getDisk(){
        return disk;
    }
    public void turnOn() {
        System.out.println("磁盘启动");
    }

    public void turnOff() {
        System.out.println("磁盘关闭");
    }
}
