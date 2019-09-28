/*
 * 文件名：StreamTest
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/28
 * 修改理由：
 * 修改内容：
 */
package Stream.三_终止操作;

import Entity.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see 查找与匹配
 * @since JDK1.8
 */
public class 查找与匹配 {
    List<Employee> list = Employee.addEmployees();

    /*
    allMatch——检查是否匹配所有元素

    anyMatch——检查是否至少匹配一个元素

    noneMatch——检查是否 所有元素都不匹配

    findFirst——返回第一个元素

    findAny——返回当前流中的任意元素

    count——返回流中元素的总个数

    max——返回流中最大值

    min——返回流中最小值
     */

    @Test
    public void test1(){
        /*allMatch:所有员工的年龄都大于10的话，返回true，否则false*/
        boolean allMatch = list.stream().allMatch(employee -> employee.getAge() > 10);

        /*anyMatch:只要有一个员工年龄大于10，返回true，一个都没有，返回false*/
        boolean anyMatch = list.stream().anyMatch(employee -> employee.getAge() > 10);

        /*noneMatch:是否所有员工的年龄都不大于10，是返回true，否返回false*/
        boolean noneMatch = list.stream().noneMatch(employee -> employee.getAge() > 10);
    }

    @Test
    public void test2(){
        /*findFirst：返回第一个元素*/
        Optional<Employee> first = list.stream().sorted(Comparator.comparing(Employee::getAge)).findFirst();
        System.out.println(first);
        /*findAny：返回当前流中的任意元素(如果是串行流，会返回第一个结果，如果是并行流，随机返回结果)*/
        Optional<Employee> any = list.parallelStream().sorted(Comparator.comparing(Employee::getAge)).findAny();
        System.out.println(any);
    }

    @Test
    public void test3(){
        /*count:返回流中age字段的总个数*/
        long count = list.stream().map(Employee::getAge).count();
        System.out.println(count);

        /*max:1.循环比较所有对象的某字段，返回最大的值的对象*/
        Optional<Employee> max = list.stream().max(Comparator.comparing(Employee::getAge));
        /*max:2.循环比较员工的年龄字段，如果年龄相等，则根据工资比较，返回年龄最大工资最大的对象*/
        Optional<Employee> max1 = list.stream().max((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getSalary().compareTo(e2.getSalary());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        });
        System.out.println(max.get());
        System.out.println(max1.get());

        /*min:1.循环比较所有对象的某字段，返回最小的值的对象*/
        Optional<Employee> min = list.stream().min(Comparator.comparing(Employee::getAge));
        /*min:2.循环比较员工的年龄字段，如果年龄相等，则根据工资比较，返回年龄最小工资最小的对象*/
        Optional<Employee> min1 = list.stream().min((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getSalary().compareTo(e2.getSalary());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        });
        System.out.println(min.get());
        System.out.println(min1.get());
    }

    @Test
    public void test4(){
        /*注意：流进行了终止操作后，不能再次使用*/
        Stream<Integer> integerStream = list.stream().map(Employee::getAge);
        long count = integerStream.count();
        //报错：java.lang.IllegalStateException: stream has already been operated upon or closed
        Stream<Integer> integerStream1 = integerStream.map(i -> i + 1);
    }

}
