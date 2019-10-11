package com.pang.facade;

/**
 * @author pang
 * @version V1.0
 * @ClassName: CPU
 * @Package com.pang.facade
 * @description:
 * @date 2019/10/11 14:20
 */
public class CPU {
    private CPU() {

    }

    private static CPU cpu = new CPU();

    public static CPU getCpu() {
        return cpu;
    }

    public void start() {
        System.out.println("CPU启动");
    }

    public void shutoff() {
        System.out.println("CPU关闭");
    }
}
