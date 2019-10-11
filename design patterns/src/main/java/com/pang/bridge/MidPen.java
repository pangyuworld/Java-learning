package com.pang.bridge;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MidPen
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:23
 */
public class MidPen extends AbstractPen {
    public MidPen(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        super.draw();
        System.out.println("中号画笔");
        return "中号画笔";
    }
}
