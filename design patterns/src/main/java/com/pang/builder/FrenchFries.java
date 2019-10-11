package com.pang.builder;

/**
 * @author pang
 * @version V1.0
 * @ClassName: FrenchFries
 * @Package com.test.order.food
 * @description: 薯条类
 * @date 2019/10/1 13:45
 */
public class FrenchFries extends Food {
    @Override
    protected float setFoodPrice() {
        // 薯条1.1美元
        return 1.1f;
    }

    @Override
    public String getFoodName() {
        return "薯条";
    }
}
