package com.pang.builder;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Coke
 * @Package com.test.order.food
 * @description: 可乐类
 * @date 2019/10/1 13:46
 */
public class Coke extends Food {
    @Override
    protected float setFoodPrice() {
        // 可乐0.5美元
        return 0.5f;
    }

    @Override
    public String getFoodName() {
        return "可乐";
    }
}
