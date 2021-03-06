package cn.ksdshpx.javase.day24;

import java.io.Serializable;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2019/2/13
 * Time: 15:30
 * Description:被序列化的对象
 */
public class Person implements Serializable{
    private static final long serialVersionUID = 3020305912544579026L;
    public String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
