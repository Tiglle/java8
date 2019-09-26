/*
 * 文件名：StreamTest
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/25
 * 修改理由：
 * 修改内容：
 */
package Stream.二_中间操作;

import Entity.Employee;
import org.junit.Test;

import java.util.List;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see 筛选与切片
 * @since JDK1.8
 */
public class 筛选与切片 {

    /*
    Stream的中间操作

一.筛选与切片
        filter——接收 Lambda ， 从流中排除某些元素。

        limit(n)——截断流，使其元素不超过给定数量。
        取流前面n个元素

        skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
        抛弃流前面n个元素，取剩下的元素

        distinct——去重，
        通过流中元素的 hashCode() 和 equals() 对比去除重复元素

二.Stream api的特点

        内部迭代：迭代操作 Stream API 内部完成

        短路：找到符合的结果就立即停止计算，没有必要处理整个流



     */

    @Test
    public void test1(){
        List<Employee> list = Employee.addEmployees();
        //中间操作：所有的中间操作不会做任何的处理
        /*1.filter*/
         list.stream()
                /*1.filter*/
                .filter(employee -> {
                    System.out.println("-----");
                    return employee.getAge() < 50;
                })
                /*2.limit*/
                .limit(3)
                /*3.skip*/
                .skip(2)
                /*4.distinct*/
                .distinct()
                .forEach(System.out::println)
                ;

         //终止操作：只有当做终止操作时，所有的中间操作会一次性的全部执行  =“惰性求值”
//         stream.forEach(System.out::println);
    }
}
