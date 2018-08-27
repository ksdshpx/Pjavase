package cn.ksdshpx.javase.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/27
 * Time: 9:38
 * Description:c3p0连接池
 */
public class C3p0Test {
    /**
     * 不使用配置文件
     */
    @Test
    public void test() {
        //1.创建连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            //2.设置四大参数
            dataSource.setDriverClass("com.mysql.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mydb1");
            dataSource.setUser("root");
            dataSource.setPassword("root123");
            //3.设置连接池参数
            dataSource.setInitialPoolSize(10);
            dataSource.setMinPoolSize(3);
            dataSource.setMaxPoolSize(30);
            dataSource.setAcquireIncrement(5);
            //4.获取连接
            Connection conn = dataSource.getConnection();
            System.out.println(conn.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用配置文件
     */
    @Test
    public void test2() {
        //1.创建连接池对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            Connection conn = dataSource.getConnection();
            System.out.println(conn.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
