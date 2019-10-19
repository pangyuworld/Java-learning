package com.pang.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestCopyOnWriteArrayList
 * @Package com.pang.video
 * @description: 写入并复制
 * @date 2019/10/18 12:10
 */
public class TestCopyOnWriteArrayList {
    public static void main(String... args) {
        HelloThread ht = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(ht).start();
        }
    }
}

class HelloThread implements Runnable {

    /**
     * 使用Collections工具创建同步集合框架
     * 使用这种方式进行创建的同步list会抛出异常 ”并发修改异常“
     */
    // private static List<String> list= Collections.synchronizedList(new ArrayList<String>());

    /**
     * 使用java.util.concurrent包下面的同步集合框架创建
     * 这种方式避免了抛出异常
     * CopyOnWriteArrayList 翻译为写入并复制，根据字面意思，就是每次写入的时候都会复制出一个新的链表
     * 使用场景：    添加操作多的时候，效率低，因为进行复制了
     *             并发迭代操作多的时候可以选择
     */
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();

    static {
        list.add("A");
        list.add("B");
        list.add("C");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());

            list.add("D");
        }
    }
}