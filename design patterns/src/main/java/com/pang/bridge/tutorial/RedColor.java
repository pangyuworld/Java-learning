package com.pang.bridge.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: RedColor
 * @Package com.pang.bridge.tutorial
 * @description:
 * @date 2019/10/10 13:16
 */
public class RedColor implements Color {
    @Override
    public String getColor() {
        System.out.println("获得了红色");
        return "红色";
    }
}
