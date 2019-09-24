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
    若Lambda 的参数列表的第一个参数，是实例方法的调用者，第二个参数(或无参)是实例方法的参数时，可以使用3的方法引用
    4. 类名 :: 实例方法名

    二、构造器引用 :
    注意：
    构造器的参数列表，需要与函数式接口中参数列表保持一致！
    5.类名 :: new

    三、数组引用
    5.类型[] :: new;

     */
    @Test
    public void test1(){
        /*1.对象:: 实例方法名*/
        Employee employee = new Employee();
        //Lambda写法
        Supplier<String> supplier = ()->employee.getName();
        //方法引用写法:employee.getName()方法和Supplier的抽象方法的返回值，参数列表一致
        Supplier<String> supplier1 = employee::getName;
        //
        String s = supplier1.get();
    }

    public void test2(){
        /*类名 :: 静态方法名*/

    }

}
