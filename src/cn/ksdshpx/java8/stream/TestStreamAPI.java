package cn.ksdshpx.java8.stream;

import cn.ksdshpx.java8.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/1/11
 * Time: 11:23
 * Description:测试java8中StreamAPI
 */
/*
 * 一、Stream的操作步骤
 *    1.创建Stream
 *    2.中间操作
 *    3.终止操作（终端操作）
 */
public class TestStreamAPI {
    //创建stream的四种方式
    @Test
    public void test() {
        //1.Collection集合的stream()或parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.Arrays的stream()
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3.Stream的of()
        Stream<String> stream3 = Stream.of("a", "b", "c");

        //4.创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(System.out::println);

    }
}
