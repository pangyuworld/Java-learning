package com.pang.builder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Order
 * @Package com.test.order
 * @description: 订单类
 * @date 2019/10/1 13:47
 */
public class Order {
    /**
     * 已点食物
     */
    private Map<String, Integer> foodList;
    /**
     * 订单价格
     */
    private float orderPrice;

    /**
     * 构造方法，初始化一些变量
     */
    public Order() {
        this.foodList = new HashMap<String, Integer>();
        this.orderPrice = 0;
    }

    /**
     * 向订单添加食物
     *
     * @param food  食物
     * @param count 数量
     * @return void
     * @author pang
     * @date 2019/10/1
     */
    public void addFood(Food food, Integer count) {
        // 已经点了多少当前这个食物
        int countLast = 0;
        // 如果能查到的话，那就把之前的值赋值给countLast
        if (foodList.get(food.getFoodName()) != null) {
            countLast = foodList.get(food.getFoodName());
        }
        // 将食物添加到订单里面
        foodList.put(food.getFoodName(), count + countLast);
        // 把价格也更新一下
        orderPrice += food.getFoodPrice() * count;
    }

    /**
     * 从订单里面删除食物
     *
     * @param food  食物
     * @param count 数量
     * @author pang
     * @date 2019/10/1
     */
    public void deleteFood(Food food, Integer count) {
        // 已经点了多少当前这个食物
        int countLast = 0;
        // 如果能查到的话，那就把之前的值赋值给countLast
        if (foodList.get(food.getFoodName()) != null) {
            countLast = foodList.get(food.getFoodName());
        } else {
            // 如果查不到的话，那就是没有食物，那就不用删除了
            // 当然，这里在学习了异常以后可以抛出一个自定义异常，不过不再考虑范围内
            return;
        }
        // 将食物从到订单里面删除
        // 这里也可以考虑一下如果数量变成了0以下的时候
        foodList.put(food.getFoodName(), countLast - count);
        // 把价格也更新一下
        orderPrice -= food.getFoodPrice() * count;
    }

    /**
     * 得到订单的价格
     *
     * @return float 订单的价格
     * @author pang
     * @date 2019/10/1
     */
    public float getOrderPrice() {
        return orderPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "foodList=" + foodList +
                ", orderPrice=" + orderPrice +
                '}';
    }
}
