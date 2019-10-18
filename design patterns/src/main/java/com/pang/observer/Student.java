package com.pang.observer;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Student
 * @Package com.pang.observer
 * @description:
 * @date 2019/10/17 15:36
 */
public class Student implements SchoolPerson {
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public void takeClass() {
        System.out.println("学生 "+studentName+" 听到了上课铃声，准备去上课");
    }

    @Override
    public void getOutOfClass() {
        System.out.println("学生 "+studentName+" 听到了下课铃声，准备去玩");
    }
}
