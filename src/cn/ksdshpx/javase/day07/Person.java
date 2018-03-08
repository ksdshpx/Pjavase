package cn.ksdshpx.javase.day07;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/3/8
 * Time: 9:58
 * Description:this关键字的使用以及应用场景
 */
public class Person {
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
        System.out.println("Person()...");
    }

    public Person(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 判断两个人年龄是否相等
     * @param person
     * @return
     */
    public boolean compare(Person person){
        return this.age == person.age;
    }

    public static void main(String[] args) {
        Person person = new Person("张三",30);
        Person person2 = new Person("李四",35);
        System.out.println(person.compare(person2));
    }
}
