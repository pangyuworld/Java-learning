package com.pang.decoration;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Clip
 * @Package com.pang.decoration.tutorial
 * @description:
 * @date 2019/10/10 14:47
 */
public class Clip extends GunDescoration {
    public Clip(Gun gun) {
        super(gun);
        System.out.println("装上了大容量弹夹");
    }

    @Override
    public void fire() {
        System.out.print(" 装上了大容量弹夹的");
        super.fire();
    }
}
