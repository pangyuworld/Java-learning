package com.pang.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BusinessReport
 * @Package com.pang.visitor
 * @description:
 * @date 2019/10/26 13:47
 */
public class BusinessReport {
    private List<Staff> staffs;

    public BusinessReport() {
        this.staffs=new LinkedList<>();
        this.staffs.add(new Coder("程序员-A"));
        this.staffs.add(new Coder("程序员-B"));
        this.staffs.add(new Coder("程序员-C"));
        this.staffs.add(new Producter("产品经理-A"));
        this.staffs.add(new Producter("产品经理-B"));
        this.staffs.add(new Producter("产品经理-C"));
    }

    public void showReport(Visitor visitor) {
        for (Staff staff:staffs){
            staff.accept(visitor);
        }
    }
}
