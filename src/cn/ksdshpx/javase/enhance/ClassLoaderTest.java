package cn.ksdshpx.javase.enhance;

import java.util.Date;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/10
 * Time: 15:07
 * Description:测试类加载器
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        //ClassLoaderAttachment classLoaderAttachment = new ClassLoaderAttachment();
        //System.out.println(classLoaderAttachment);
        Class clazz = new MyClassLoader("itcastlib").loadClass("ClassLoaderAttachment");
        Date d = (Date)clazz.newInstance();
        System.out.println(d);
    }
}
