package cn.ksdshpx.java8.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2017/12/28
 * Time: 20:14
 * Function:Lambda表达式的几个小练习
 */
public class TestLambda3 {
    List<Employee> employees = Arrays.asList(new Employee("张三", 30, 3333.33),
            new Employee("李四", 25, 5555.55),
            new Employee("王五", 38, 6666.66),
            new Employee("赵六", 30, 2222.22),
            new Employee("田七", 32, 8888.88));

    /*
     *需求：调用Collections.sort()方法，通过定制排序比较两个Employee(先按年龄比，年龄相同按
     * 姓名比)，使用Lambda进行参数传递
     */
    @Test
    public void test() {
        Collections.sort(employees, (e1, e2) -> e1.getAge() == e2.getAge() ? e1.getName().compareTo(e2.getName()) : e1.getAge() - e2.getAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    /*
     *需求：①声明函数式接口，接口中声明抽象方法public String getValue(String str)
     *      ②声明类TestLambda,类中编写方法使用接口作为参数，将一个字符串转成大写,并作为方法的返回值
     *      ③再将一个字符串的第二个和第四个索引位置进行截取字串
     */
    //处理字符串
    public String handleStr(String str, HandleStrInter handleStrInter) {
        return handleStrInter.getValue(str);
    }

    @Test
    public void test2() {
        String upperStr = handleStr("sFitKsDshPX", (str) -> str.toUpperCase());
        System.out.println("upperStr:" + upperStr);
        String subStr = handleStr("sFitKsDshPX", (str) -> str.substring(2, 5));
        System.out.println("subStr:" + subStr);
    }

    /*
     *需求：①声明一个带两个泛型的函数式接口，泛型类型为<T,R>,T为参数，R为返回值
     *      ②接口中声明对应抽象方法
     *      ③在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和
     *      ④再计算两个long型参数的乘机
     */
    //处理long型数据
    public Long calculate(Long x, Long y, HandleLong<Long, Long> handleLong) {
        return handleLong.handle(x, y);
    }

    @Test
    public void test3() {
        Long num = calculate(100L, 200L, (x, y) -> x + y);
        System.out.println("num:" + num);
        Long num2 = calculate(100L, 200L, (x, y) -> x * y);
        System.out.println("num2:" + num2);
    }
}
