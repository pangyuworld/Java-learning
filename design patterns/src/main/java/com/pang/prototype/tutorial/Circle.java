package com.pang.prototype.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Circle
 * @Package com.pang.prototype
 * @description:
 * @date 2019/10/7 11:49
 */
public class Circle extends Shape {
    public Circle() {
        type = "Circle";
    }

    @Override
    void deaw() {
        System.out.println("画了圆形");
    }
}
