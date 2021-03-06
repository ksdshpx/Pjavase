package cn.ksdshpx.javase.day18;

import java.util.Objects;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/14
 * Time: 15:27
 * Description:
 */
public class Student implements Comparable {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Student student = (Student) o;
        int compareResult = this.getAge() - student.getAge();
        return compareResult == 0 ? this.getName().compareTo(student.getName()) : compareResult;
    }
}
