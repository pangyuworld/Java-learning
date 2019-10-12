package com.source.code.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ArrayListTest
 * @Package com.source.code.test
 * @description:
 * @date 2019/10/11 19:24
 * 1. c.toArray might (incorrectly) not return Object[] (see 6260652)
 */
public class ArrayListTest {
    /**
     * 下面这个例子展示了为什么说
     */
    public void test1() {
        List<String> list = Arrays.asList("abc");
        System.out.println(list.getClass());
        // class java.util.Arrays$ArrayList
        Object[] objArray = list.toArray();
        System.out.println(objArray.getClass());
        // class [Ljava.lang.String;
        objArray[0] = new Object();
        // 上面就要抛出异常java.lang.ArrayStoreException
        // 原因是，objArray里面保存的是String类型，然后我们要插入一个Object类型，因此出现向下转型错误
        // 这个坑很深啊
    }

    public static void main(String... args) {
        // new ArrayListTest().test1();
        ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("hello");
        arrayList.add(0,"world");
        arrayList.add(2,"world1");
        System.out.println(arrayList.get(0));
        for (String s:arrayList){
            System.out.println(s);
        }
    }
}
