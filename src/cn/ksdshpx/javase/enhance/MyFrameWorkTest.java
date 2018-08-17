package cn.ksdshpx.javase.enhance;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/17
 * Time: 23:50
 * Description:利用反射模拟框架
 */
public class MyFrameWorkTest {
    public static void main(String[] args) {
        InputStream inputStream = MyFrameWorkTest.class.getClassLoader().getResourceAsStream("cn/ksdshpx/javase/enhance/config.properties");
        Properties props = new Properties();
        try {
            props.load(inputStream);
            String className = props.getProperty("className");
            Collection collection = (Collection) Class.forName(className).newInstance();
            ReflectPoint rp1 = new ReflectPoint(3, 3);
            ReflectPoint rp2 = new ReflectPoint(1, 1);
            ReflectPoint rp3 = new ReflectPoint(3, 3);
            collection.add(rp1);
            collection.add(rp2);
            collection.add(rp3);
            collection.add(rp1);
            System.out.println(collection.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
