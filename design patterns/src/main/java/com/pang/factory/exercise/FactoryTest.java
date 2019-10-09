package com.pang.factory.exercise;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: FactoryTest
 * @Package com.pang.factory.exercise
 * @description:
 * @date 2019/10/7 15:37
 */
public class FactoryTest {
    @Test
    public void test(){
        CarFactory factory=new AudiFactory();
        factory.buildCar();
        CarFactory factory1=new Mercedes();
        factory1.buildCar();
        StringBuilder stringBuilder = new StringBuilder("|");
        System.out.println(stringBuilder);
    }
}
