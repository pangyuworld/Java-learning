package com.pang.builder;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Food
 * @Package com.test.order
 * @description: 食物类，所有食物的虚基类
 * @date 2019/10/1 13:39
 */
public abstract class Food {
    /**
     * 食物价格
     */
    private float foodPrice;

    /**
     * 设置食物价格，这个方法在构造函数里面自动调用了
     *
     * @return float 返回食物要设置的价格
     * @author pang
     * @date 2019/10/1
     */
    protected abstract float setFoodPrice();

    /**
     * 构造方法
     *
     * @author pang
     * @date 2019/10/1
     */
    public Food() {
        this.foodPrice = setFoodPrice();
    }

    /**
     * 获得食物名字
     *
     * @return java.lang.String 食物名字
     * @author pang
     * @date 2019/10/1
     */
    public abstract String getFoodName();

    /**
     * 获得食物价格
     *
     * @return float 食物价格
     * @author pang
     * @date 2019/10/1
     */
    public float getFoodPrice() {
        return foodPrice;
    }
}
