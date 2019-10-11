package com.pang.builder;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Burger
 * @Package com.test.order.food
 * @description: 汉堡类
 * @date 2019/10/1 13:43
 */
public class Burger extends Food {
    @Override
    protected float setFoodPrice() {
        // 汉堡1.5美元一个
        return 1.5F;
    }

    @Override
    public String getFoodName() {
        return "汉堡";
    }
}
