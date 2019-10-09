/*
 * 文件名：TestOptional
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/10/9
 * 修改理由：
 * 修改内容：
 */
package Optional;

import Entity.Employee;
import org.junit.Test;

import java.util.Optional;

/*
 一、Optional 容器类：用于尽量避免空指针异常

1.Optional.of(T t) : 创建一个 Optional 实例

2.Optional.empty() : 创建一个空的 Optional 实例

3.Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例

4.isPresent() : 判断是否包含值

5.orElse(T t) :  如果调用对象包含值，返回该值，否则返回t

6.orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值

7.map(Function f): 如果有值，对值进行处理，并返回处理后的Optional，否则返回 Optional.empty()

8.flatMap(Function mapper):与 map 类似，要求返回值必须是Optional

 */
public class TestOptional {

    @Test
    public void test1(){
        //1.Optional.of(Employee e) : 创建一个 包含Employee的Optional 实例
        Optional<Employee> op1 = Optional.of(new Employee());

        //2.Optional.empty() : 创建一个空的 Optional 实例
        Optional<Employee> op2 = Optional.empty();

        //3.Optional.ofNullable(Employee e):若 e 为 null,调用empty()创建空Optional实例，否则创建 包含Employee的Optional 实例
        Optional<Employee> op3 = Optional.ofNullable(new Employee());

        //4.isPresent() : 判断是否包含值：Optional的value != null
        boolean present = op3.isPresent();

        //5.orElse(Employee e) :  如果op2中包含不为null的Employee的值，返回该Employee值，否则返回new Employee()
        Employee employee = op2.orElse(new Employee());

        //6.orElseGet(Supplier s) :如果op2中包含值，返回该值，否则返回 s 获取的值
        op2.orElseGet(Employee::new);
        op2.orElseGet(()->{
            if(true){
                return new Employee("小明");
            }else {
                return new Employee("小红");
            }
        });

        //7.map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
        op3.map(e->{
            return e.getName();
        });
        op2.map(e->{
            e.setName("小明");
            return e;
        });

        //8.flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
        op3.flatMap(e->{
            return Optional.of(e.getName());
        });

    }

}
