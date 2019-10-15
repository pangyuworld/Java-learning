package com.pang.template;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Coffee
 * @Package com.pang.template
 * @description: 咖啡
 * @date 2019/10/15 10:32
 */
public class Coffee extends Drink {
    public Coffee() {
        super("咖啡");
    }

    @Override
    protected void prepareDrink() {
        System.out.println("准备咖啡豆");
    }

    @Override
    protected void mix() {
        System.out.println("搅拌均匀");
    }
}
