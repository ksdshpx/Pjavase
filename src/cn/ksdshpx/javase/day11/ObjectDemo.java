package cn.ksdshpx.javase.day11;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/4/19
 * Time: 22:43
 * Description:Object类的重要方法
 */
class Person{
    private String name;
    private int age;

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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //覆盖equals方法
    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(!(o instanceof Person)){
            throw new ClassCastException("类型错误！");
        }
        Person p = (Person) o;
        return this.age == p.age && this.getName().equals(p.getName());
    }

}
public class ObjectDemo {
    public static void main(String[] args) {
        Person p1 = new Person("李四",21);
        Person p2 = new Person("李四",21);
        System.out.println(p1.equals(p2));
    }
}
