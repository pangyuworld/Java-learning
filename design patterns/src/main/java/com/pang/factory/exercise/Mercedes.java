package com.pang.factory.exercise;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Mercedes
 * @Package com.pang.factory.exercise
 * @description:
 * @date 2019/10/7 15:31
 */
public class Mercedes implements CarFactory {
    public void buildCar() {
        System.out.println(new Car("奔驰").getType());
    }
}
