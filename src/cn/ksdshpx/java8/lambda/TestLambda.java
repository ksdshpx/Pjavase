package cn.ksdshpx.java8.lambda;

import org.junit.Test;

import java.util.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2017/12/27
 * Time: 11:53
 */
public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    //lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    //需求：打印年龄大于35的员工信息
    List<Employee> employees = Arrays.asList(new Employee("张三", 30, 3333.33),
            new Employee("李四", 25, 5555.55),
            new Employee("王五", 38, 6666.66),
            new Employee("赵六", 45, 2222.22),
            new Employee("田七", 32, 8888.88));

    public List<Employee> filterEmployeeByAge(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() > 35) {
                emps.add(employee);
            }
        }
        return emps;
    }

    @Test
    public void test3() {
        List<Employee> list = filterEmployeeByAge(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //需求：打印工资大于5000的员工信息
    public List<Employee> filterEmployeeBySalary(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() > 5000) {
                emps.add(employee);
            }
        }
        return emps;
    }

    @Test
    public void test4() {
        List<Employee> list = filterEmployeeBySalary(employees);
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式一:策略设计模式
    public List<Employee> filterEmployees(List<Employee> list,MyPredict<Employee> myPredict){
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if(myPredict.test(employee)){
                emps.add(employee);
            }
        }
        return emps;
    }

    @Test
    public void test5(){
        List<Employee> list = filterEmployees(employees,new FilterEmployeeByAge());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("---------------");
        list = filterEmployees(employees,new FilterEmployeeBySalary());
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式二：匿名内部类
    @Test
    public void test6(){
        List<Employee> list = filterEmployees(employees, new MyPredict<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() < 5000;
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三：lambda表达式
    @Test
    public void test7(){
        List<Employee> list = filterEmployees(this.employees, (e) -> e.getSalary() > 5000);
        list.forEach(System.out::println);
    }
}
