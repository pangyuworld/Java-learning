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
        Gun gun = new AwmGun();

        gun = new Clip(gun);
        gun = new Silencer(gun);
        gun = new Sight(gun);

        gun.fire();

    }
}
