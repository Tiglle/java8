/*
 * 文件名：TestLambda
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/23
 * 修改理由：
 * 修改内容：
 */
package lambda.lambda语法;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see TestLambda
 * @since JDK1.8
 */
public class TestLambda {

/*
一、Lambda 表达式的基础语法：Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符

箭头操作符将 Lambda 表达式拆分成两部分：
左侧：Lambda 表达式的参数列表
右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体

语法格式一：无参数，无返回值

语法格式二：有一个参数，并且无返回值

语法格式三：若只有一个参数，小括号可以省略不写

语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句

语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写

语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”


二、Lambda 表达式需要“函数式接口”的支持
函数式接口：接口中只有一个抽象方法的接口，称为函数式接口。 可以使用注解 @FunctionalInterface 修饰
可以检查是否是函数式接口

*/

    /*
    -----------------------------------------------------------------------------语法格式一：无参数，无返回值
    */
    @Test
    public void test1(){
        Runnable r = ()-> System.out.println("1");
    }

    /*
    -----------------------------------------------------------------------------语法格式二：有一个参数，并且无返回值
                                                                                                                       语法格式三：若只有一个参数，小括号可以省略不写
    */
    @Test
    public void test2(){
        Consumer<String> c = s -> System.out.println("1");
    }

    /*
    -----------------------------------------------------------------------------语法格式四：有两个以上的参数，有返回值，并且 Lambda 体中有多条语句,必须加()和{}
    */
    @Test
    public void test3(){
        Comparator<String> comparator = (s1,s2)-> {
            if(s1.equals(s2)){
                return 0;
            }else if(!s1.equals(s2)){
                return -1;
            }else {
                return 0;
            }
        };
    }

    /*
    -----------------------------------------------------------------------------语法格式五：若 Lambda 体中只有一条语句， return 和 大括号都可以省略不写
    */
    @Test
    public void test4(){
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
    }

    /*
    -----------------------------------------------------------------------------语法格式六：Lambda 表达式的参数列表的数据类型可以省略不写，因为JVM编译器通过上下文推断出，数据类型，即“类型推断”
    */

    @Test
    public void test5(){
        List<String> list = new ArrayList<>();
        Predicate<String> p = str-> str.length()>1;
        List<String> list1 = new ArrayList<>();
        list.forEach(s1->{
            if(p.test(s1)){
                list1.add(s1);
            }
        });
    }
}
