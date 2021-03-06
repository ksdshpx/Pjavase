package cn.ksdshpx.java8.lambda;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2017/12/27
 * Time: 13:17
 */
public class FilterEmployeeByAge implements MyPredict<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 35;
    }

}
