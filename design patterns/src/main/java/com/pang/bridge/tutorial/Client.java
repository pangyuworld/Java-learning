package com.pang.bridge.tutorial;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:28
 */
public class Client {

    @Test
    public void test(){
        AbstractPen pen=new BigPen(new RedColor());
        pen.draw();

        System.out.println("---------------------");

        AbstractPen pen1=new MidPen(new BlackColor());
        pen1.draw();
    }
}
