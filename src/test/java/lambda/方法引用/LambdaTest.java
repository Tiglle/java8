/*
 * 文件名：LambdaTest
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/24
 * 修改理由：
 * 修改内容：
 */
package lambda.方法引用;

import Entity.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see LambdaTest
 * @since JDK1.8
 */
public class LambdaTest {

    /*
    一、方法引用：若 Lambda 体中的功能，已经有方法提供了实现，可以使用方法引用（可以将方法引用理解为 Lambda 表达式的另外一种表现形式）

    注意(包含1和2):
    方法引用所引用的方法的参数列表与返回值类型，需要与函数式接口中抽象方法的参数列表和返回值类型保持一致！可以使用1和2的方法引用
    1. 对象的引用 :: 实例方法名
    2. 类名 :: 静态方法名

    注意：
    若Lambda 表达式  参数列表  的第一个参数，是实例方法的调用者 ，第二个参数是实例方法的参数时，可以使用3的方法引用
                                                            eg:
                                                            1.lambda参数列表的第一个参数.实例方法()
                                                            2.lambda参数列表的第一个参数.实例方法(lambda.参数列表的第二个参数)
                                                            3.lambda参数列表的第一个参数.实例方法(lambda.参数列表的第二个参数,lambda.参数列表的第三个参数)
                                                            4.等...

    3. 类名 :: 实例方法名

    二、构造器引用 :
    注意：
    构造器的参数列表，需要与函数式接口中参数列表保持一致！
    4.类名 :: new

    三、数组引用
    5.类型[] :: new;

     */
    @Test
    public void test1(){
        /*1.对象:: 实例方法名*/
        Employee employee = new Employee();
        //Lambda写法
        Supplier<String> supplier = ()->employee.getName();
        //方法引用写法:employee.getName()方法和Supplier的抽象方法的 返回值，参数列表一致
        Supplier<String> supplier1 = employee::getName;
        //
        String s = supplier1.get();
    }

    @Test
    public void test2(){
        /*类名 :: 静态方法名*/
        //Lambda写法
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
        //方法引用写法:Integer.compare方法和Comparator的抽象方法的 返回值，参数列表一致
        Comparator<Integer> comparator1 = Integer::compare;

    }

    @Test
    public void test3(){
        /*类名 :: 实例方法名*/
        Function<Employee,Object> function = s -> s.getAge();
        //1.lambda参数列表的第一个参数.实例方法()
        Function<Employee,Object> function1 = Employee::getAge;

        //2.lambda参数列表的第一个参数.实例方法(参数列表的第二个参数)
        BiFunction<String,String,Boolean> biFunction = (t,u)-> t.equals(u);
        BiFunction<String,String,Boolean> biFunction1 = String::equals;

        //3.lambda参数列表的第一个参数.实例方法(lambda.参数列表的第二个参数,lambda.参数列表的第三个参数)
        MyBiFunction<Employee,String,Integer,String> myBiFunction = (e,s,i)->e.ratioSizeAge(s,i);
        MyBiFunction<Employee,String,Integer,String> myBiFunction1 = Employee::ratioSizeAge;
    }

    @Test
    public void test4(){
        /*类名 :: new--构造器的参数列表，需要与函数式接口中参数列表保持一致！*/
        //Lambda写法-无参构造方法
        Supplier<Employee> supplier = ()->new Employee();
        //方法引用写法:无参构造方法-new Employee()与函数式接口Supplier的get()抽象方发参数列表一致
        Supplier<Employee> supplier1 = Employee::new;

        //Lambda写法-有参构造方法1
        Function<String,Employee> function = s->new Employee("小明");
        //方法引用写法:有参构造方法1
        Function<String,Employee> function1 = Employee::new;

        //Lambda写法-有参构造方法2
        BiFunction<String,Integer,Employee> function2 = (s,i)->new Employee("小明",20);
        //方法引用写法:有参构造方法2
        BiFunction<String,Integer,Employee> function3 = Employee::new;
        //....等
    }

    @Test
    public void test5() {
        /*类型[] :: new--构造器的参数列表，需要与函数式接口中参数列表保持一致！*/
        //lambda写法
        Function<Integer, String[]> function = i -> new String[i];
        //方法引用写法
        Function<Integer, String[]> function1 = String[]::new;
        //等...
    }
}
