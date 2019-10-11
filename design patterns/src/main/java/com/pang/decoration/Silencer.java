package com.pang.decoration;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Silencer
 * @Package com.pang.decoration.tutorial
 * @description:
 * @date 2019/10/10 14:46
 */
public class Silencer extends GunDescoration {
    public Silencer(Gun gun) {
        super(gun);
        System.out.println("装上了消音器");
    }

    @Override
    public void fire() {
        System.out.print(" 装上了消音器的");
        super.fire();
    }
}
