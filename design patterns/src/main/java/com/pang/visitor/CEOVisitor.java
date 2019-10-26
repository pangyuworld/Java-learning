package com.pang.visitor;

/**
 * @author pang
 * @version V1.0
 * @ClassName: CEOVisitor
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:49
 */
public class CEOVisitor extends Visitor {

    @Override
    public void visit(Coder coder) {
        System.out.println("工程师：" + coder.getName() + " 的KPI为 " + coder.getKbi());
    }

    @Override
    public void visit(Producter producter) {
        System.out.println("产品经理：" + producter.getName() + " 的KPI为 " + producter.getKbi());
    }
}
