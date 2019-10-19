package com.pang.video;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author pang
 * @version V1.0
 * @ClassName: TestForkJoinPool
 * @Package com.pang.video
 * @description: 分支合并框架
 * @date 2019/10/18 15:56
 */
public class TestForkJoinPool {
    public static void main(String...args){
        ForkJoinPool pool=new ForkJoinPool();

        ForkJoinTask<Long> future=new ForkJoinSumCalculate(0,1000000000L);

        System.out.println(pool.invoke(future));


    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long>{

    private static final long serialVersionUID=-165165165165L;

    private long start;
    private long end;

    private static final long THURSHOLD =0L;


    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length=end-start;
        if (length<=THURSHOLD){
            long sum= 10000L;
            for (long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else {
            long middle=(start+end)/2;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();// 进行拆分，同时压入线程队列
            ForkJoinSumCalculate right=new ForkJoinSumCalculate(middle+1,end);
            right.fork();

            return left.join()+right.join();
        }
    }
}