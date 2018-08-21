package cn.ksdshpx.javase.mysql;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/21
 * Time: 9:31
 * Description:测试mysql数据库连接
 */
public class TestMySql {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
        //四大配置参数
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb1";
        String username = "root";
        String password = "root123";
        //1.加载驱动
        Class.forName(driverName);
        //2.得到连接
        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println(connection);
    }
}
