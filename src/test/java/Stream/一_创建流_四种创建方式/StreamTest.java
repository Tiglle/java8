/*
 * 文件名：StreamTest
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/25
 * 修改理由：
 * 修改内容：
 */
package Stream.一_创建流_四种创建方式;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see StreamTest
 * @since JDK1.8
 */
public class StreamTest {

    /*
      一、Stream API 的操作步骤：

          1. 创建 Stream

          2. 中间操作

          3. 终止操作(终端操作)
          注意：流进行了终止操作后，不能再次使用


      二、创建Stream的四种方式

          1.通过Collection 提供了两个方法
          stream()   串行流
          parallelStream()  并行流

          2.通过 Arrays 中的 stream() 获取一个数组流
           stream() 数组流

          3.通过 Stream 类中静态方法 of()
          of()

          4.创建无限流
          Stream.iterate()  迭代
          Stream.generate() 生成
     */

    @Test
    public void test1(){
        /*1.通过Collection 提供了两个方法*/
        List<String> list = new ArrayList<>();
        //串行流
        Stream<String> stream = list.stream();
        //并行流
        Stream<String> parallelStream = list.parallelStream();

        /*2.通过 Arrays 中的 stream() 获取一个数组流*/
        Integer[] integers = new Integer[10];
        //数组流
        Stream<Integer> stream1 = Arrays.stream(integers);

        /*3.通过 Stream 类中静态方法 of()*/
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

        /*4.创建无限流*/
        //迭代   ---   无限执行lambda方法体
        Stream<Integer> iterate = Stream.iterate(0, i -> i + 1);
        //生成
        Stream<Double> generate = Stream.generate(Math::random);
    }
}
