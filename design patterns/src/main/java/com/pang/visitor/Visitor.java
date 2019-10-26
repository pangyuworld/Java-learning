package com.pang.visitor;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Visitor
 * @Package com.pang.visitor
 * @description: 访问者模式
 * @date 2019/10/26 13:40
 */
public abstract class Visitor {
    public abstract void visit(Coder coder);
    public abstract void visit(Producter producter);
}
