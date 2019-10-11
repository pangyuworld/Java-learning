package com.pang.bridge;

/**
 * @author pang
 * @version V1.0
 * @ClassName: LittlePen
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:23
 */
public class LittlePen extends AbstractPen {
    public LittlePen(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        super.draw();
        System.out.println("小号画笔");
        return "小号画笔";
    }
}
