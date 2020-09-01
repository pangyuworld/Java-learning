package com.io;

import java.io.*;
import java.util.StringJoiner;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ObjectStreamTest
 * @Package com.io
 * @description:
 * @date 2020/3/2 8:56
 */
public class ObjectStreamTest implements Serializable {
    private int id;
    private String name;
    transient private String password;

    public int getId() {
        return id;
    }

    public ObjectStreamTest setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ObjectStreamTest setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ObjectStreamTest setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ObjectStreamTest.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("password='" + password + "'")
                .toString();
    }

    public static void main(String[] args) {
        ObjectStreamTest object = new ObjectStreamTest();
        object.setId(22).setName("天选之人").setPassword("1231331");
        System.out.println(object);
        try {


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);

            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream= new ObjectInputStream(byteArrayInputStream);
            ObjectStreamTest object1 = (ObjectStreamTest) objectInputStream.readObject();
            System.out.println(object1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
