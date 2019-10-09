package com.pang.prototype.tutorial;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Main
 * @Package com.pang.prototype
 * @description:
 * @date 2019/10/7 11:57
 */
public class Main {
    @Test
    public void test(){
        ShapeCache.loadCache();

        Shape shape=ShapeCache.getShape("1");
        System.out.println(shape.getType());
        shape.deaw();
        System.out.println(shape);
        shape=ShapeCache.getShape("2");
        System.out.println(shape.getType());
        shape.deaw();
        System.out.println(shape);
        shape=ShapeCache.getShape("3");
        System.out.println(shape.getType());
        shape.deaw();
        System.out.println(shape);
        System.out.println("----------------");
        shape=ShapeCache.getShape("1");
        System.out.println(shape.getType());
        shape.deaw();
        System.out.println(shape);
    }
}
