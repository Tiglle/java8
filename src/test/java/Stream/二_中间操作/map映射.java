/*
 * 文件名：map映射
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/25
 * 修改理由：
 * 修改内容：
 */
package Stream.二_中间操作;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see map映射
 * @since JDK1.8
 */
public class map映射 {

    /*
    映射

    1.map——接收 Lambda ， 将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。

    f2.flatMap——接收一个函数作为参数，将多个流中的每个值都应用此函数，然后把所有流连接成一个流

     */

    @Test
    public void test1(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        /*1.map：接受一个lambda（函数）表达式作为参数，并将此lambda函数引用到每个元素上*/
        Stream<String> stringStream = list.stream().map(String::toUpperCase);

        /*2.flatMap：接受一个lambda（函数）表达式作为参数，然后把所有流连接成一个流*/
        List<String> list1 = Arrays.asList("111","222");
        List<String> list2 = Arrays.asList("333","444");
        List<List<String>> list3 = new ArrayList<>();
        list3.add(list1);
        list3.add(list2);
        System.out.println(list3);
        //list3结构：[[111, 222], [333, 444]]
        //map映射，操作Stream中的每个元素，如果Stream流是多层的，返回结果也是多层流
        Stream<Stream<String>> streamStream = list3.stream().map(l->l.stream().map(String::toUpperCase));
        //flagMap映射，操作Stream中的每个元素，如果Stream是多层的，会合并这些流，返回一层流
        Stream<String> stringStream1 = list3.stream().flatMap(l -> l.stream().map(String::toUpperCase));
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();

        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }

        return list.stream();
    }
}
