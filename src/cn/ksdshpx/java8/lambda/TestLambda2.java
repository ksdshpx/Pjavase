package cn.ksdshpx.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2017/12/27
 * Time: 21:57
 * Function:Lambda表达式的基础语法
 */

/*
 * 1.Lambda表达式需要函数式接口的支持
 * 2.函数式接口：若接口中只有一个抽象方法，则该接口为函数式接口，可以使用@FunctionalInterface修饰
 */
public class TestLambda2 {
    //Lambda表达式一：无参，无返回值
    @Test
    public void test() {
        int num = 0;//JDK1.8之前必须修饰为final,而JDK1.8不用显示的被final修饰，但本质上还是final的，只是默认加上了
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Lambda!" + num);
            }
        };
        r.run();
        System.out.println("-----------------");
        Runnable r2 = () -> System.out.println("Hello Lambda2!" + num);
        r2.run();
    }


    //Lambda表达式二：有一个参(若只有一个参数，则小括号可以不写)，无返回值
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("测试Lambda表达式！");
        System.out.println("------------------");
        Consumer<String> consumer2 = x -> System.out.println(x);
        consumer2.accept("测试Lambda表达式2");
    }

    //Lambda表达式三：有两个以上参数，有返回值并且Lambda体中有多条语句
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    //Lambda表达式四：有两个以上参数，有返回值并且Lambda体中只有一条语句，则return和大括号都可以不写
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    //需求：对一个数进行运算
    public Integer calculate(Integer num, NumOper numOper) {
        return numOper.operate(num);
    }

    @Test
    public void test5() {
        Integer num = calculate(100, (x) -> x * x);
        System.out.println(num);
        System.out.println("---------------");
        System.out.println(calculate(200, (y) -> y + 200));
    }

}
