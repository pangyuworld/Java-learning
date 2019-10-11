package com.pang.decoration.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Sight
 * @Package com.pang.decoration.tutorial
 * @description: 瞄准镜
 * @date 2019/10/10 14:46
 */
public class Sight extends GunDescoration {
    public Sight(Gun gun) {
        super(gun);
        System.out.println("装上了八倍镜");
    }

    @Override
    public void fire() {
        System.out.print(" 装上了八倍镜的");
        super.fire();
    }
}
