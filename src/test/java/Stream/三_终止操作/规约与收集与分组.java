/*
 * 文件名：规约与收集与分组
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

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see 规约与收集与分组
 * @since JDK1.8
 */
public class 规约与收集与分组 {
    List<Employee> list = Employee.addEmployees();

    /*
    reduce
        规约：将流中的值结合，得到一个值

    collect
        收集：将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法

    Collectors.groupingBy
        分组：将数据分组
     */

    @Test
    public void test1(){
        /*规约reduce*/
        /*1.获取员工年龄的总和(执行流程：循环执行流程：
                        1.x=0,y=第一个员工的年龄，x+y=sum1
                        2.x=sum1,y=第二个员工的年龄,x+y=sum2
                        3.x=sum2,y=第三个员工的年龄,x+y=sum3
                        4. 。。。。。。
                        */
        Integer reduce = list.stream().map(Employee::getAge).reduce(/*0为初始值*/0, (x, y) -> x + y);
        /*因为没初始值，有可能为null，所以返回值为Optional*/
        Optional<Integer> reduce1 = list.stream().map(Employee::getAge).reduce(/*0为初始值*/ (x, y) -> x + y);
        /*计算所有员工出现张的次数*/
        Optional<Integer> 张s =list.stream().map(Employee::getName).flatMap(s -> {
            List<Character> cList = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                cList.add(chars[i]);
            }
            return cList.stream();
        }).map(c -> {
            if (c.equals('张')) {
                return 1;
            } else {
                return 0;
            }
        }).reduce(Integer::sum)
        ;
        System.out.println(张s.get());

    }

    @Test
    public void test2(){
        /*收集成集合*/
        //1.将员工姓名，年龄收集成一个新List,Set等(两种方式)
        List<String> collect = list.stream().map(Employee::getName).collect(Collectors.toList());
        ArrayList<Integer> collect2 = list.stream().map(Employee::getAge).collect(Collectors.toCollection(ArrayList::new));
        Set<Integer> collect1 = list.stream().map(Employee::getAge).collect(Collectors.toSet());
        HashSet<Integer> collect3 = list.stream().map(Employee::getAge).collect(Collectors.toCollection(HashSet::new));

        /*收集流中数据个数=count*/
        Long collect4 = list.stream().collect(Collectors.counting());
        System.out.println(collect4);

        /*获取平均值*/
        Double collect5 = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));

        /*获取总和*/
        IntSummaryStatistics collect6 = list.stream().collect(Collectors.summarizingInt(Employee::getAge));

        /*最大值*/
        Optional<Employee> collect7 = list.stream().collect(Collectors.maxBy((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge())));

        /*通用数据：包含平均值，和，最小最大值*/
        IntSummaryStatistics collect8 = list.stream().collect(Collectors.summarizingInt(Employee::getAge));
        double average = collect8.getAverage();
        long count = collect8.getCount();
        int max = collect8.getMax();
        int min = collect8.getMin();
        long sum = collect8.getSum();

    }

    @Test
    public void test3(){
        /*根据年龄分组，返回值为map，key为年龄的值，value符合key年龄值的所有员工*/
        Map<Integer, List<Employee>> collect = list.stream().collect(Collectors.groupingBy(Employee::getAge));

        /*自定义分组，根据条件分成 穷人，小康，富有*/
        Map<String, List<Employee>> collect1 = list.stream().collect(Collectors.groupingBy(employee -> {
            if (employee.getSalary() > 1) {
                return "穷人";
            } else if (employee.getSalary() > 1000) {
                return "小康";
            } else {
                return "富有";
            }
        }));

        /*多级分组,根据  年龄  和  姓名  分组*/
        Map<Integer, Map<String, List<Employee>>> collect2 = list.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getName)));

        /*分区：满足条件一个区，不满足条件一个区，分为true和false区*/
        Map<Boolean, List<Employee>> collect3 = list.stream().collect(Collectors.partitioningBy(employee -> employee.getAge() > 20));
    }
}
