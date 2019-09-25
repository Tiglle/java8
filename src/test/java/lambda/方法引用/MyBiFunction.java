/*
 * 文件名：MyBiFunction
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/9/25
 * 修改理由：
 * 修改内容：
 */
package lambda.方法引用;

import java.util.function.BiFunction;

/**
 *测试方法引用 --类名::实例方法
 * @author Administrator
 * @version 1.0
 * @see MyBiFunction
 * @since JDK1.8
 */
@FunctionalInterface
public interface MyBiFunction<T,U,V,R> {

    R apply(T t,U u,V v);
}
