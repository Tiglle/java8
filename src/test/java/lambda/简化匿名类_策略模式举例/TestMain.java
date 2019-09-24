/*
 * 文件名：TestMain
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/23
 * 修改理由：
 * 修改内容：
 */
package lambda.简化匿名类_策略模式举例;

import Entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see TestMain
 * @since JDK1.8
 */
public class TestMain {

    @Test
    public void test() {
        List<Employee> list = Employee.addEmployees();
        /*正常策略模式不同的策略需要定义多个实现类，这里采用匿名类实现*/

        /*java7*/
        //策略1：年龄大于30的员工
        List<Employee> compare = compare(list, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getAge() > 30) {
                    return true;
                }
                return false;
            }
        });
        //策略2：工资大于100的员工
        List<Employee> compare1 = compare(list, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                if (employee.getSalary() > 100) {
                    return true;
                }
                return false;
            }
        });

        /*java8简化匿名类的声明*/
        //策略1：年龄大于30的员工
        List<Employee> compare2 = compare(list, employee -> employee.getAge() > 30);
        //策略2：工资大于100的员工
        List<Employee> compare3 = compare(list, employee -> employee.getSalary() > 100);

    }

    private  List<Employee> compare(List<Employee> list,MyPredicate<Employee> myPredicate){
        List<Employee> returnList = new ArrayList<Employee>();

        for (Employee employee:list){
            if (myPredicate.test(employee)) {
                returnList.add(employee);
            }
        }
        return returnList;
    }



}
