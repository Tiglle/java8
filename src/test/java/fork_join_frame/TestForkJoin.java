/*
 * 文件名：TestForkJoin
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/10/9
 * 修改理由：
 * 修改内容：
 */
package fork_join_frame;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see TestForkJoin
 * @since JDK1.8
 */
public class TestForkJoin {

    @Test
    public void test1(){
        //fork/join的task要通过ForkJoinPool来执行，可以指定线程数量，不指定根据系统性能默认创建
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new MyForkJoin(0L, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
    }

    @Test
    public void test2(){
        //使用LongStream的原生方法 用parallel()变成并行流，计算总和
        LongStream.rangeClosed(0L,100000000L)
                .parallel()
                .sum();
    }
}
