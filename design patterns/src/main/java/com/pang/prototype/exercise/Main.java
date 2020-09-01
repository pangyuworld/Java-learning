package com.pang.prototype.exercise;


/**
 * @author pang
 * @version V1.0
 * @ClassName: Main
 * @Package com.pang.prototype.exercise
 * @description: 用原型模式生成“三好学生”奖状。同一学校的“三好学生”奖状除了获奖人姓名不同，其他都相同，属于相似对象的复制，同样可以用原型模式创建，然后再做简单修改就可以了
 * @date 2019/10/7 12:08
 */
public class Main {
    public void test() throws CloneNotSupportedException {

        Certificate certificate = new Certificate();
        Certificate certificate2 = (Certificate) certificate.clone();

        certificate.getWinner().setStudentName("小胖儿");
        System.out.println(certificate);

        System.out.println(certificate2);

        System.out.println(certificate == certificate2);

    }
}
