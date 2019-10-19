package com.pang.video;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestCallable
 * @Package com.pang.video
 * @description: 通过实现Callable接口创建线程
 * @date 2019/10/18 12:45
 *
 * Callable和Runnable接口的区别：
 *      1. 方法可以有返回值，可以抛出异常
 *      2. 可以通过泛型进行约束
 *      3. 执行Callable 方式，需要FutureTask 实现类的支持，用于接收运算结果。FutureTask 是 Future 接口的实现类
 *      4. FutureTask可以用于闭锁
 */
public class TestCallable {
    public static void main(String...arags){
        ThreadDemoByCallable td=new ThreadDemoByCallable();

        FutureTask<Integer> result=new FutureTask<Integer>(td);
        // 运行线程
        new Thread(result).start();

        // 接收结果
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 通过实现Callable接口创建线程
 */
class ThreadDemoByCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i=0;i<100;i++){
            sum+=i;
        }
        return sum;
    }
}
/**
 * 通过实现Runnable接口创建线程
 */
class ThreadDemoByRunnable implements Runnable{

    @Override
    public void run() {
    }
}
