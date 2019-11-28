package com.pang.decoration;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.decoration
 * @description:
 * @date 2019/10/10 14:52
 */
public class Client {
    @Test
    public void test() {
        // 拾起了AWM
        Gun gun = new AwmGun();
        // 給枪装上配件
        gun = new Clip(gun);
        gun = new Silencer(gun);
        gun = new Sight(gun);
        // 开火
        gun.fire();

    }
    @Test
    public void dtest(){
        System.out.println("hello");
    }
}
