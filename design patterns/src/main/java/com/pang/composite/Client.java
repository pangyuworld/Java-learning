package com.pang.composite;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.composite
 * @description:
 * @date 2019/10/11 10:52
 */
public class Client {
    @Test
    public void test(){
        // TODO Auto-generated method stub

        //从大到小创建对象 学校
        Organization university = new University("清华大学");

        //创建 学院
        Organization computerCollege = new College("计算机学院");
        Organization infoEngineercollege = new College("信息工程学院");


        //创建各个学院下面的系(专业)
        computerCollege.add(new Profession("软件工程"));
        computerCollege.add(new Profession("网络工程"));
        computerCollege.add(new Profession("计算机科学与技术"));

        //
        infoEngineercollege.add(new Profession("通信工程"));
        infoEngineercollege.add(new Profession("信息工程"));

        //将学院加入到 学校
        university.add(computerCollege);
        university.add(infoEngineercollege);

        university.print();
        // infoEngineercollege.print();
    }
}
