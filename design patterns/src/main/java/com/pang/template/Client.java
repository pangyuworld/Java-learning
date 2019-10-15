package com.pang.template;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.template
 * @description:
 * @date 2019/10/15 10:35
 */
public class Client {
    public static void main(String... args) {
        Drink coffee = new Coffee();
        coffee.make();

        Drink milk = new Milk();
        milk.make();
    }
}
