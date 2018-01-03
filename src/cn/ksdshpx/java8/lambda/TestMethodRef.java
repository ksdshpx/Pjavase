package cn.ksdshpx.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/3
 * Time: 16:12
 * Function:方法引用
 */

/*
 * 一、方法引用：若Lambda体中的内容已经有方法已经实现了，我们可以使用“方法引用”
 *          （可以理解为方法引用是Lambda表达式的另外一种表现形式）
 *
 *  三种语法格式：
 *          ① 对象::实例方法名
 *          ② 类::静态方法名
 *          ③ 类::实例方法名
 *
 *  注意事项：
 *          ①Lambda体中调用方法的参数列表和返回值类型，要与函数式接口的抽象方法的参数列表和返回值类型相同
 *          ②若Lambda参数列表中的第一个参数是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用类::实例方法名
 *
 * 二、构造器引用
 *     语法格式：
 *            类::new
 *   注意事项：需要调用的构造器的参数列表与函数式接口的抽象方法的参数列表一致
 *
 * 三、数组引用
 *     语法格式：
 *            type[]:new
 */
public class TestMethodRef {
    // ① 对象::实例方法名
    @Test
    public void test(){
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("hello,methodref");

        Consumer<String> consumer2 = System.out::println;
        consumer2.accept("hello,methodref2");
    }

    @Test
    public void test2(){
        Employee employee = new Employee("zhangsan",20,3000);
        Supplier<String> supplier = () -> employee.getName();
        String name = supplier.get();
        System.out.println(name);

        Supplier<Integer> supplier2 = employee::getAge;
        Integer age = supplier2.get();
        System.out.println(age);
    }

    //② 类::静态方法名
    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> comparator2 = Integer::compare;
    }

    //③ 类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> biPredicate = (x,y) -> x.equals(y);
        BiPredicate<String,String> biPredicate2 = String::equals;
    }

    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> supplier = () -> new Employee();
        Employee employee = supplier.get();
        System.out.println(employee);

        Supplier<Employee> supplier2 = Employee::new;
        Employee employee2 = supplier2.get();
        System.out.println(employee2);
    }

    @Test
    public void test6(){
        Function<String,Employee> function = (str) -> new Employee(str);
        Employee employee = function.apply("zhangsan");
        System.out.println(employee);

        Function<String,Employee> function2 = Employee::new;
        Employee employee2 = function2.apply("lisi");
        System.out.println(employee2);
    }

    //数组引用
    @Test
    public void test7(){
        Function<Integer,String[]> function = (x) -> new String[x];
        String[] strArray = function.apply(10);
        System.out.println(strArray.length);

        Function<Integer,String[]> function2 = String[]::new;
        String[] strArray2 = function2.apply(20);
        System.out.println(strArray2.length);
    }
}
