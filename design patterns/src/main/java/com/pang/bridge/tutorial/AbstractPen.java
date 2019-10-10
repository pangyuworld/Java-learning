package com.pang.bridge.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AbstractPen
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:17
 */
public abstract class AbstractPen {
    private Color penColor;

    public AbstractPen(Color color) {
        this.penColor=color;
    }

    public String draw() {
        System.out.println("使用 " + penColor.getColor() + " 画画");
        return "使用 " + penColor.getColor() + " 画画";
    }
}
