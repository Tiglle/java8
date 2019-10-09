/*
 * 文件名：MyInterface
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/10/9
 * 修改理由：
 * 修改内容：
 */
package 接口中的默认方法和静态方法;

/**
 * 〈一句话简述该类/接口的功能〉
 * 〈功能详细描述〉
 *
 * @author Administrator
 * @version 1.0
 * @see HaHaInterface
 * @since JDK1.8
 */
public interface HaHaInterface {

    default String laugh(){
        return "哈哈";
    }
}
