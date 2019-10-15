package com.pang.template;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Milk
 * @Package com.pang.template
 * @description:
 * @date 2019/10/15 10:33
 */
public class Milk extends Drink {
    public Milk() {
        super("牛奶");
    }

    @Override
    protected void prepareDrink() {
        System.out.println("准备纯牛奶");
    }
}
