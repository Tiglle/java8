/*
 * 文件名：StreamTest
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/29
 * 修改理由：
 * 修改内容：
 */
package Stream.stream案例练习;

import Entity.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see StreamTest
 * @since JDK1.8
 */
public class StreamTest {
    List<Employee> list = Employee.addEmployees();
    List<Transaction> transactions = null;

    /*
    1.	给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？给定【1，2，3，4，5】， 应该返回【1，4，9，16，25】。
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().map(x -> x * x).forEach(System.out::println);
    }

    /*
    2.	怎样用 map 和 reduce 方法数一数流中有多少个Employee呢？
     */

    @Test
    public void test2() {
        Optional<Integer> reduce = list.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(reduce);
    }

    /*
    3. 查找所有来自剑桥的交易员，并按姓名排序
     */
    @Test
    public void test3() {
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .forEach(System.out::println);
    }

    /*
    4. 返回所有交易员的姓名字符串，按字母顺序排序
     */
    @Test
    public void test4() {
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted();
    }


    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

}


//交易员
class Trader {

    private String name;
    private String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trader [name=" + name + ", city=" + city + "]";
    }

}


//交易
class Transaction {

    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Transaction [trader=" + trader + ", year=" + year + ", value="
                + value + "]";
    }

}
