package com.pang.visitor;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:49
 */
public class Client {
    public static void main(String[] args) {
        // 构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO看报表 ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO看报表 ===========");
        report.showReport(new CTOVisitor());
    }
}
