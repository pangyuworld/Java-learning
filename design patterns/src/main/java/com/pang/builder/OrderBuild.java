package com.pang.builder;

/**
 * @author pang
 * @version V1.0
 * @ClassName: OrderBuild
 * @Package com.test.order
 * @description: 点餐机
 * @date 2019/10/1 14:45
 */
public class OrderBuild {
    /**
     * 订单
     */
    private Order order = new Order();

    /**
     * 点餐
     *
     * @param food  食物
     * @param count 数量
     * @return void
     * @author pang
     * @date 2019/10/1
     */
    public void addFood(Food food, Integer count) {
        this.order.addFood(food, count);
    }

    /**
     * 去餐
     *
     * @param food  食物
     * @param count 数量
     * @return void
     * @author pang
     * @date 2019/10/1
     */
    public void deleteFood(Food food, Integer count) {
        this.order.deleteFood(food, count);
    }

    /**
     * 创建订单
     *
     * @return com.test.order.Order 构建好的订单
     * @author pang
     * @date 2019/10/1
     */
    public Order build() {
        if (this.order.getOrderPrice() > 10) {
            return null;
        }
        return this.order;
    }
}
