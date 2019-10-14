/*
 * 文件名：TestLocalDateTime
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/10/14
 * 修改理由：
 * 修改内容：
 */
package 时间和日期;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
1.特性
 LocalDate、LocalTime、LocalDateTime 类的实例是不可变的对象
是线程安全的
分别表示使用 ISO-8601日历系统的日期、时间、日期和时间

 LocalDate：年月日

 LocalTime：时分秒

 LocalDateTime：年月日时分秒

 2.实例化的方式
    类名.now();
    类名.of(int year, int month, int dayOfMonth, int hour, int minute, int second);

 3.常用方法
    增加天，周，月，年
    并返回新对象
    plusDays
    plusWeeks
    plusMonths
    plusYears

    减少天，周，月，年
    并返回新对象
    minusDays
    minusWeeks
    minusMonths
    minusYears

    将  纳秒，秒，分，时，月份的天，年份的天，月，年 修改为指定的值
    并返回新对象
    withNano
    withSecond
    withMinute
    withHour
    withDayOfMonth,
    withDayOfYear,
    withMonth,
    withYear

 4.Instant
    时间戳，使用 Unix 元年  1970年1月1日 00:00:00 所经历的毫秒值

 5.计算间隔
    Duration：计算两个时间的间隔，适用：（Instant ）
    Period：计算两个日期的间隔，适用：(Instant,LocalDate,LocalTime,LocalDateTime)

 6.时间矫正器
    TemporalAdjuster：有时我们可能需要获取例如：将日期调整到“下个周日”等操作。
    TemporalAdjusters：该类通过静态方法提供了大量的常用 TemporalAdjuster 的实现

 7.时间格式化 与 时区的处理
 带时区的时间或日期
 DateTimeFormatter
 ZonedDate
 ZonedTime
 ZonedDateTime

 */
public class TestLocalDateTime {

    /*
    2.实例化的方式
     */
    @Test
    public void test1(){
        LocalDateTime ldt1 = LocalDateTime.now();

        LocalDateTime ldt2 = LocalDateTime.of(2016,12,31,24,60,60);
    }

    /*
    3.常用方法
 */
    @Test
    public void test2(){
        //当前时间增加3天
        //因为 为不可变对象，所以任何操作都不会改变原对象，会产生一个新对象
        LocalDateTime ldt1 = LocalDateTime.now();
        System.out.println(ldt1);
        LocalDateTime ldt2 = ldt1.plusDays(3);
        System.out.println(ldt2);
        //修改为指定月，时，分，秒，纳秒
        LocalDateTime localDateTime = ldt2.withDayOfMonth(10).withHour(5).withMinute(30).withSecond(45).withNano(1000);
    }

    /*
    4.Instant
     */
    @Test
    public void test4(){
        Instant ins = Instant.now();  //默认使用 UTC 时区：世界协调时间=美国时间，和中国时间相差8小时
        System.out.println(ins);//2019-10-14T06:41:22.127Z

        //偏移8小时
        OffsetDateTime odt = ins.atOffset(ZoneOffset.ofHours(8));//2019-10-14T14:52:51.048+08:00
        System.out.println(odt);

        //获取ins的时间戳
        System.out.println(ins.toEpochMilli());//1571035971048

        //返回1970-01-01T00:00:00Z的时间 + 100秒
        Instant instant = Instant.ofEpochSecond(100);
        System.out.println(instant);
    }

    /*
    5.Duration：计算两个时间的间隔
        Period：计算两个日期的间隔
     */
    @Test
    public void test5(){
        Instant start1 = Instant.parse("2017-10-03T10:15:30.00Z");
        Instant end1 = Instant.parse("2017-10-03T10:16:30.00Z");
        Duration duration = Duration.between(start1, end1);
        System.out.println(duration);
        System.out.println("end1比start1大："+
                duration .getSeconds()+"秒"+
                duration .getNano()+"纳秒"
                );


        System.out.println("===============================");
        LocalDate start2 = LocalDate.now();
        //增加10个月
        LocalDate end2 = start2.plusMonths(10);
        //计算时间间隔
        Period period  = Period.between(start2, end2);//P10M
        System.out.println(period );
        System.out.println("end2比start2大："+
                period .getYears()+"年"+
                period .getMonths()+"月"+
                period .getDays()+"日");
        //判断period的     years < 0 || months < 0 || days < 0
        System.out.println(period.isNegative());
    }

    /*
    6.时间矫正器
     */
    @Test
    public void test6(){
        LocalDateTime ldt1 = LocalDateTime.now();
        //指定为下一个周日
        LocalDateTime ldt2 = ldt1.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(ldt2);
        //获取下一个工作日 (周日到周四+一天，周五+3天，周六+2天)
        LocalDateTime result = ldt2.with(temporal -> {
            //获取周几
            DayOfWeek dayOfWeek = ldt2.getDayOfWeek();
            //如果是周五，+3天
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt2.plusDays(3);
                //如果是周六，+2天
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt2.plusDays(2);
                //否则 + 1天
            } else {
                return ldt2.plusDays(1);
            }
        });
        System.out.println(result);
    }

    /*
    7.时间格式化 与 时区的处理
        带时区的时间或日期
     */
    @Test
    public void test7(){
        //格式化时间
        DateTimeFormatter format1 = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm");
        LocalDateTime ldt1 = LocalDateTime.now();
        String str1 = format1.format(ldt1);
        System.out.println(str1);
        String str2 = format2.format(ldt1);
        System.out.println(str2);
        //将 时间字符串 转为Dated对象
        LocalDateTime date = ldt1.parse(str1);
        System.out.println(date);

        //带时区的时间或日期
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt);
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(zdt);
        //可用时区
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
    }
}
