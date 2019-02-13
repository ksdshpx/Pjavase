package cn.ksdshpx.javase.day24;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/13
 * Time: 15:26
 * Description:对象的序列化
 *             注意：被序列化的对象必须实现Serializable接口
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException{
        writeObj();
    }

    public static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\my.object"));
        oos.writeObject(new Person("张三",18));
        oos.close();
    }
}
