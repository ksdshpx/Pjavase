package cn.ksdshpx.javase.day24;

import java.io.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/13
 * Time: 15:26
 * Description:对象的序列化以及反序列化
 *             注意：被序列化的对象必须实现Serializable接口
 */
public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeObj();
        readObj();
    }

    public static void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\my.object"));
        Person p = (Person) ois.readObject();
        System.out.println(p.getName()+":"+p.getAge());
    }

    public static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\my.object"));
        oos.writeObject(new Person("张三",18));
        oos.close();
    }
}
