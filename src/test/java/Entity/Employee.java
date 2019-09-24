/*
 * 文件名：Employee
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/23
 * 修改理由：
 * 修改内容：
 */
package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see Employee
 * @since JDK1.8
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer employeeNo;

    private String name;

    private Integer age;

    private Double salary;

    public static List<Employee> addEmployees() {
        List<Employee> list = new ArrayList<Employee>();
        Employee employee1 = new Employee(11112,"张三",10,1111.1);
        Employee employee2 = new Employee(11113,"张三",20,2222.2);
        Employee employee3 = new Employee(11114,"张三",30,3333.3);
        Employee employee4 = new Employee(11115,"张三",40,4444.4);
        Employee employee5 = new Employee(11116,"张三",50,5555.5);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        return list;
    }

}
