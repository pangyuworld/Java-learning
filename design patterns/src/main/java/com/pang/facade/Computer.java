package com.pang.facade;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Computer
 * @Package com.pang.facade
 * @description:
 * @date 2019/10/11 14:20
 */
public class Computer {
    private Disk disk;
    private CPU cpu;
    private Moniter moniter;
    public Computer(){
        this.disk=Disk.getDisk();
        this.cpu=CPU.getCpu();
        this.moniter=Moniter.getMoniter();
    }

    public void start(){
        this.cpu.start();
        this.disk.turnOn();
        this.moniter.on();
    }

    public void stop(){
        this.moniter.off();
        this.disk.turnOff();
        this.cpu.shutoff();
    }
}
