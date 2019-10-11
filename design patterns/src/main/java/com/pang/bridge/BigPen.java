package com.pang.bridge;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BigPen
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:22
 */
public class BigPen extends AbstractPen {
    public BigPen(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        super.draw();
        System.out.println("大号画笔");
        return "大号画笔";
    }
}
