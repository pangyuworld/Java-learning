package com.ioc;

/**
 * Setter/Getter
 * 可写（writeable）/可读（readable）
 * @author pang
 * @version V1.0
 * @ClassName: Person
 * @Package com.ioc
 * @description: 描述人的POJO
 * @date 2019/12/27 21:39
 */
public class Person {
    String name;

    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
