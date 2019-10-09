/*
 * 文件名：MyForkJoin
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/10/9
 * 修改理由：
 * 修改内容：
 */
package fork_join_frame;

import javax.sound.midi.Soundbank;
import java.util.concurrent.RecursiveTask;

/**
1.fork/join并行框架：
        将一个大任务拆分(fork)成若干个小任务，拆到不可在拆时(临界值)，分配到多个线程的列队中，再将一个个小任务运算的结果进行join
        RecursiveTask<V> 有返回值，为V
        RecursiveAction 无返回值

 2.fork/join框架与传统线程池的区别：
        传统线程池：当一个线程执行完或者阻塞或者执行时间比较长，后面的待列队会一直等待
        fork/join框架：当一个线程执行完，会去其他未执行完的列队的末尾偷一个任务执行，保证没有空闲线程——“工作窃取”模式（work-stealing）

 3.fForkJoinPool:
        ork/join的task要通过ForkJoinPool来执行，可以指定线程数量，不指定根据系统性能默认创建
 */



//计算1到一亿的值
public class MyForkJoin extends RecursiveTask<Long> {

    private static final long serialVersionUID = 13475679780L;

    private long start;
    private long end;

    //临界值
    private static final long THERSHOLD = 10000L;

    public MyForkJoin(long start,long end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //拆分算法要自己写
        long length = end - start;

        //如果拆分fork的数量达到临界值，进行运算
        if(length<=THERSHOLD){

            long sum = 0;

            for (long i = start; i <=end ; i++) {
                sum+=i;
            }

            return sum;

        //如果拆分fork的数量没有达到临界值，继续拆分
        }else{

            long middle = (start+end)/2;

            //向左拆分（开始到一半）
            MyForkJoin left = new MyForkJoin(start,middle);
            left.fork();

            //向右拆分（一半到结尾）
            MyForkJoin right = new MyForkJoin(middle+1,end);
            right.fork();

            //以上的逻辑，会一直拆分成n个小分支作为n个线程的列队，最后把所有n个小分支进行join
            return left.join()+right.join();

        }
    }
}
