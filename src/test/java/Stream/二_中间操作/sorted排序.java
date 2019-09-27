/*
 * 文件名：sorted排序
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/27
 * 修改理由：
 * 修改内容：
 */
package Stream.二_中间操作;

import Entity.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see sorted排序
 * @since JDK1.8
 */
public class sorted排序 {

    /*
        sorted()
        自然排序 : 根据String的compareTo实现排序规则

        sorted(Comparator comparator)
        定制排序：
     */
    @Test
    public void test(){
        List<Employee> list = Employee.addEmployees();

        /*sorted():排序年龄*/
        list.stream().map(Employee::getAge).sorted().forEach(System.out::println);

        /*sorted(Comparator comparator)：根据年龄等排员工*/
        list.stream().sorted(Comparator.comparing(Employee::getAge).reversed().thenComparing(Employee::getName)).forEach(System.out::println);
    }
}
