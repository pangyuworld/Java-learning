package com.pang.observer;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Teacher
 * @Package com.pang.observer
 * @description:
 * @date 2019/10/17 15:36
 */
public class Teacher implements SchoolPerson {
    private String teacherName;

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public void takeClass() {
        System.out.println("老师 "+teacherName+" 听到了上课铃声，准备去给学生上课");
    }

    @Override
    public void getOutOfClass() {
        System.out.println("老师 "+teacherName+" 听到了下课铃声，准备回办公室");
    }
}
