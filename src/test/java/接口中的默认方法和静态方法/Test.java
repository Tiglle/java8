/*
 * 文件名：Test
 * 版权：Copyright by 启海云仓 qihaiyun.com
 * 描述：
 * 创建人：Administrator
 * 创建时间：2019/10/9
 * 修改理由：
 * 修改内容：
 */
package 接口中的默认方法和静态方法;

/**
 1.Java 8中允许接口中包含具有具体实现的方法，该方法称为“默认方法”，默认方法使用default关键字修饰。

 2.类优先原则：当一个类继承了父类，实现了有默认方法接口，并且父类和接口拥有相同的方法，那么接口的默认方法或被忽略

 3.接口冲突：如果两个父接口提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），那么实现类必须覆盖该方法来解决冲突
                    ：接口的多继承  或者  类的多实现

 */
public class Test {

    @org.junit.Test
    public void test1(){
        //2.类优先原则：当MyClass1类继承了父类HeiHeiClass，实现了有默认方法接口HaHaInterface，并且HeiHeiClass和HaHaInterface拥有相同的方法，那么接口HaHaInterface的默认方法或被忽略
        MyClass myClass = new MyClass();
        System.out.println(myClass.laugh());
    }

    @org.junit.Test
    public void test2(){
      //3.接口冲突
    }

}
