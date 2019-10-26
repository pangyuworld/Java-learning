package com.pang.visitor;

import java.util.Random;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Staff
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:44
 */
public abstract class Staff {
    private String name;
    private int kbi;

    public Staff(String name) {
        this.name = name;
        this.kbi= new Random().nextInt(10);
    }

    public abstract void accept(Visitor visitor);

    public String getName() {
        return name;
    }

    public int getKbi() {
        return kbi;
    }
}
