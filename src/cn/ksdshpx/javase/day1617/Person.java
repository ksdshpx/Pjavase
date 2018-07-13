package cn.ksdshpx.javase.day1617;

import java.util.Objects;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/12
 * Time: 15:10
 * Description:Person实体类，测试集合功能用
 */
public class Person implements Comparable {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        return this.getAge() == person.getAge() ? this.getName().compareTo(person.getName()) : this.getAge() - person.getAge();
    }
}
