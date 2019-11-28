package com.pang.bridge;

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
        // 红色大号笔
        pen.draw();

        System.out.println("---------------------");

        AbstractPen pen1=new MidPen(new BlackColor());
        // 黑色中号笔
        pen1.draw();

        // 白色的小号笔
        AbstractPen pen3=new LittlePen(new WriteColor());
    }
}
