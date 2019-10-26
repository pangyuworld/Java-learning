package com.pang.visitor;

/**
 * @author pang
 * @version V1.0
 * @ClassName: CTOVisitor
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:49
 */
public class CTOVisitor extends Visitor {
    @Override
    public void visit(Coder coder) {
        System.out.println("工程师：" + coder.getName() + " 的代码量为 " + coder.getCodeLines());
    }

    @Override
    public void visit(Producter producter) {
        System.out.println("产品经理：" + producter.getName() + " 的产品数量为 " + producter.getProductCont());
    }
}
