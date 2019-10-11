package com.pang.builder;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: OrderBuildTest
 * @Package com.test.order
 * @description:
 * @date 2019/10/1 14:51
 */
public class OrderBuildTest {

    @Test
    public void main() {
        OrderBuild orderBuild=new OrderBuild();
        orderBuild.addFood(new Burger(),5);
        orderBuild.addFood(new Coke(),4);
        orderBuild.addFood(new FrenchFries(),10);
        orderBuild.deleteFood(new Burger(),2);
        orderBuild.deleteFood(new FrenchFries(),9);
        Order order=orderBuild.build();
        System.out.println(order);
    }
}
