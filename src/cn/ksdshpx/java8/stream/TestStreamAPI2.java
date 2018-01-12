package cn.ksdshpx.java8.stream;

import cn.ksdshpx.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/12
 * Time: 10:14
 * Description:Stream 中间操作
 */
/*
 * 筛选与切片
 *       1.filter:接受lambda表达式，从流中排除某些元素
 *       2.limit:截断流，使其元素不超过给定数量
 *       3.skip(n):跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流，与limit(n)互补
 *       4.distinct:筛选，通过流所生成元素的hashCode()和equals()去除重复元素
 */
public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(new Employee("张三", 30, 3333.33),
            new Employee("李四", 25, 5555.55),
            new Employee("王五", 38, 6666.66),
            new Employee("赵六", 45, 2222.22),
            new Employee("田七", 32, 8888.88),
            new Employee("田七", 32, 8888.88),
            new Employee("田七", 32, 8888.88));

    //内部迭代：迭代操作由Stream API完成
    @Test
    public void test() {
        //中间操作（不会执行任何操作）
        Stream<Employee> stream = employees.stream()
                .filter((e) -> {
                    System.out.println("Stream API的中间操作不会有任何结果");
                    return e.getAge() > 30;
                });
        //终止操作（一次性执行全部操作，惰性求值或延迟加载）
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test2() {
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //limit操作
    @Test
    public void test3() {
        employees.stream()
                .filter((e) -> {
                    System.out.println("短路");
                    return e.getAge() > 30;
                })
                .limit(2)
                .forEach(System.out::println);
    }

    //skip操作
    @Test
    public void test4() {
        employees.stream()
                .filter((e) -> e.getAge() > 30)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }
}
