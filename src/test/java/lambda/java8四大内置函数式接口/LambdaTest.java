/*
 * 文件名：LambdaTest
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/24
 * 修改理由：
 * 修改内容：
 */
package lambda.java8四大内置函数式接口;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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
     Java8 内置的四大核心函数式接口

     1.Consumer<T> : 消费型接口：接收一个泛型参数，不返回值
            void accept(T t);

     2.Supplier<T> : 供给型接口：不接受参数，返回泛型类型的值
            T get();

     3.Function<T, R> : 函数型接口：接受一个泛型参数，返回另外一个泛型值
            R apply(T t);

     4.Predicate<T> : 断言型接口：接受一个泛型参数，返回布尔类型的值
            boolean test(T t);

     */

    /*
    * ---------------------------------------------------------------------------Consumer<T>
    * */
    @Test
    public void test1(){
        /*1.接收一个泛型参数，不返回值*/
        /*打印传入的参数*/
        Consumer<String> consumer = s -> System.out.println("传入的参数:"+s);
        consumer.accept("小明");
    }

    /*
     * ---------------------------------------------------------------------------Supplier<T>
     * */
    @Test
    public void test2(){
        /*2.不接受参数，返回泛型类型的值*/
        /*返回一定数量的随机值*/
        List<Integer> list = getNumList(10,()-> (int)Math.random()*100);
        list.forEach(i-> System.out.println(i));
    }

    private List<Integer> getNumList(int size, Supplier<Integer> supplier){
        List<Integer> returnList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            returnList.add(supplier.get());
        }

        return returnList;
    }

    /*
     * ---------------------------------------------------------------------------Function<T, R>
     * */
    @Test
    public void test3(){
        /*3.接受一个泛型参数，返回另外一个泛型值*/
        /*打印传入的号码的字符串*/
        System.out.println(getStrNumber(1,i->"我是"+i+"号"));
    }

    private String getStrNumber(Integer number, Function<Integer,String> function){
        return function.apply(number);
    }

    /*
     * ---------------------------------------------------------------------------Function<T, R>
     * */
    @Test
    public void test4(){
        /*4.接受一个泛型参数，返回布尔类型的值*/
        /*返回符合条件的新List*/
        List<String> list = Arrays.asList("11","2222","3333");
        List<String> newList = getNewList(list,s -> s.length()>2);
        newList.forEach(System.out::println);
    }

    private List<String> getNewList(List<String> list, Predicate<String> predicate){
        List<String> returnList = new ArrayList<>();

        list.forEach(s -> {
            if (predicate.test(s)) {
                returnList.add(s);
            }
        });

        return returnList;
    }

}
