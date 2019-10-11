package com.pang.facade;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.facade
 * @description:
 * @date 2019/10/11 14:29
 */
public class Client {
    @Test
    public void test(){
        Computer computer=new Computer();
        computer.start();
        computer.stop();
    }
}
