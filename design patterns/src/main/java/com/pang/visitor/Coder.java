package com.pang.visitor;

import java.util.Random;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Coder
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:45
 */
public class Coder extends Staff {
    public Coder(String name) {
        super(name);
    }

    @Override
    public void accept(Visitor visitor) {
    visitor.visit(this);
    }

    /**
     * 得到代码行数
     */
    public int getCodeLines(){
        return new Random().nextInt(10000);
    }
}
