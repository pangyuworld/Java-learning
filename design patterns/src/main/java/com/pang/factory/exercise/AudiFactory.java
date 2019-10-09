package com.pang.factory.exercise;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AudiFactory
 * @Package com.pang.factory.exercise
 * @description:
 * @date 2019/10/7 15:31
 */
public class AudiFactory implements CarFactory {
    public void buildCar() {
        System.out.println(new Car("奥迪").getType());
    }
}
