package com.pang.visitor;

import java.util.Random;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Producter
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:46
 */
public class Producter extends Staff {
    public Producter(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * 得到产产品数量
     */
    public int getProductCont() {
        return new Random().nextInt(100);
    }
}
