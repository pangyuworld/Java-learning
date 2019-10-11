package com.pang.decoration;

/**
 * @author pang
 * @version V1.0
 * @ClassName: AwmGun
 * @Package com.pang.decoration.tutorial
 * @description:
 * @date 2019/10/10 14:42
 */
public class AwmGun implements Gun {
    @Override
    public void fire() {
        System.out.print(" AWM进行了射击");
    }
}
