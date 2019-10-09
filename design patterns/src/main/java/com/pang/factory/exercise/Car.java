package com.pang.factory.exercise;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Car
 * @Package com.pang.factory.exercise
 * @description:
 * @date 2019/10/7 15:30
 */
public class Car {
    private String type;

    public Car(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Car setType(String type) {
        this.type = type;
        return this;
    }
}
