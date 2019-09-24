/*
 * 文件名：MyPredicate
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/23
 * 修改理由：
 * 修改内容：
 */
package lambda.简化匿名类_策略模式举例;

/**
 * 策略模式
 *
 * @author Administrator
 * @version 1.0
 * @see MyPredicate
 * @since JDK1.8
 */
public interface MyPredicate<T>  {

    boolean test(T t);

}
