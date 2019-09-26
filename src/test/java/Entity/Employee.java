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

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see Employee
 * @since JDK1.8
 */
@Getter
@Setter
@ToString
//@Data   生成equals和hashCode是包含全部字段
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private Integer employeeNo;

    private String name;

    private Integer age;

    private Double salary;

    public Employee(String name) {
        this.name = name;
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 对比年龄
     * @param employee
     * @param name
     * @param age
     * @return
     */
    public String ratioSizeAge(String name,Integer age){
        if(this.getAge()>age){
            return this.getName()+"比"+name+"的年龄大";
        }else {
            return this.getName()+"比"+name+"的年龄大";
        }
    }

    public static List<Employee> addEmployees() {
        List<Employee> list = new ArrayList<Employee>();
        Employee employee1 = new Employee(11112,"张2",10,1111.1);
        Employee employee2 = new Employee(11113,"张3",20,2222.2);
        Employee employee3 = new Employee(11114,"张4",30,3333.3);
        Employee employee4 = new Employee(11115,"张5",40,4444.4);
        Employee employee5 = new Employee(11116,"张6",50,5555.5);
        Employee employee6 = new Employee(11116,"张6",50,5555.5);
        Employee employee7 = new Employee(11116,"张6",50,5555.5);
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        list.add(employee4);
        list.add(employee5);
        list.add(employee6);
        list.add(employee7);
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeNo, employee.employeeNo) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNo, name, age, salary);
    }
}
