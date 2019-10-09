package com.pang.prototype.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Triangle
 * @Package com.pang.prototype
 * @description:
 * @date 2019/10/7 11:50
 */
public class Triangle extends Shape {
    public Triangle() {
        type="三角形";
    }

    @Override
    void deaw() {
        System.out.println("绘制了三角形");
    }
}
