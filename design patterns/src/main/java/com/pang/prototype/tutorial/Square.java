package com.pang.prototype.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Square
 * @Package com.pang.prototype
 * @description:
 * @date 2019/10/7 11:50
 */
public class Square extends Shape {
    public Square() {
        type = "正方形";
    }

    @Override
    void deaw() {
        System.out.println("绘制了正方形");
    }
}
