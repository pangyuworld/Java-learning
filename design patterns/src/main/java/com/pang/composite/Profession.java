package com.pang.composite;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Profession
 * @Package com.pang.composite
 * @description:
 * @date 2019/10/11 10:38
 */
public class Profession extends Organization {
    public Profession(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println(getName());
    }
}
