package com.pang.bridge;

/**
 * @author pang
 * @version V1.0
 * @ClassName: WriteColor
 * @Package com.pang.bridge
 * @description:
 * @date 2019/11/23 20:45
 */
public class WriteColor implements Color {
    @Override
    public String getColor() {
        System.out.println("获得了白色");
        return "白色";
    }
}
