package com.pang.bridge;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BlackColor
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:16
 */
public class BlackColor implements Color {
    @Override
    public String getColor() {
        System.out.println("获得了黑色");
        return "黑色";
    }
}
