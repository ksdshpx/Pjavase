package cn.ksdshpx.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2017/12/29
 * Time: 13:37
 * Function:Java8内置的四大函数式接口
 *        1、Consumer<T>:消费性接口
 *              void accept(T t);
 *
 *        2、Supplier<T>:供给型接口
 *              T get();
 *
 *        3、Function<T,R>:函数型接口
 *              R apply(T t);
 *
 *        4、Predicate<T>:断言型接口
 *              boolean test(T t);
 *
 */
public class TestLambda4 {
    //Consumer<T>:消费性接口
    @Test
    public void test() {
        happy(10000, (m) -> System.out.println("买个iphonex,消费了" + m + "元"));
    }

    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //Supplier<T>:供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(100,() -> (int) (Math.random()*100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    //产生指定个数的随机整数放入集合中
    public List<Integer> getNumList(int count, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    //Function<T,R>:函数型接口
    @Test
    public void test3(){
        String upperStr = handleStr("sFitGueSt",(str) -> str.toUpperCase());
        System.out.println("upperStr:"+upperStr);
        String subStr = handleStr("金融业技术公司",(str) -> str.substring(2,5));
        System.out.println("subStr:"+subStr);
    }
    //处理字符串
    public String handleStr(String str, Function<String,String> function){
        return function.apply(str);
    }

    //Predicate<T>:断言型接口
    @Test
    public void test4(){
        List<String> newList = Arrays.asList("Hello","Lambda","ok","JAVA","TradingDay");
        List<String> returnList = filterStr(newList,(str) -> str.length() > 4);
        System.out.println(returnList);
    }

    //将满足条件的字符串放入集合中并返回
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> filterList = new ArrayList<>();
        for (String str : list) {
            if(predicate.test(str)){
                filterList.add(str);
            }
        }
        return filterList;
    }
}
