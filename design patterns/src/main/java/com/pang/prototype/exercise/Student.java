package com.pang.prototype.exercise;

import java.io.Serializable;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Student
 * @Package com.pang.prototype
 * @description: 学生类
 * @date 2019/10/7 13:37
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 2L;
    private String studentName = "张星宇";

    public String getStudentName() {
        return studentName;
    }

    public Student setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                '}';
    }
}
