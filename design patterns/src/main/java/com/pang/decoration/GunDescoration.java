package com.pang.decoration;

/**
 * @author pang
 * @version V1.0
 * @ClassName: GunDescoration
 * @Package com.pang.decoration.tutorial
 * @description:
 * @date 2019/10/10 14:43
 */
public class GunDescoration implements Gun{
    // 这里聚合了一个Gun
    private Gun gun;

    public GunDescoration(Gun gun) {
        this.gun=gun;
    }

    @Override
    public void fire() {
        gun.fire();
    }
}
