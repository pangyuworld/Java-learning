package com.pang.template;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Drink
 * @Package com.pang.template
 * @description: 饮料虚基类
 * @date 2019/10/15 10:25
 */
public abstract class Drink {
    private String drinkName;

    public final void make() {
        this.boiled();
        this.prepareDrink();
        this.mix();
        System.out.println("准备好了一杯" + drinkName);
    }

    public Drink(String drinkName) {
        this.drinkName = drinkName;
    }

    protected void boiled() {
        System.out.println("烧开水");
    }

    protected abstract void prepareDrink();

    protected void mix() {

    }
}
