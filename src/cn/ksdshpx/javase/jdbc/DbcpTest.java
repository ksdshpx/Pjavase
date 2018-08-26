package cn.ksdshpx.javase.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/26
 * Time: 17:50
 * Description:dbcp数据库连接池测试
 */
public class DbcpTest {
    @Test
    public void test(){
        Connection conn = null;
        try {
            //1.创建dbcp数据库连接池对象
            BasicDataSource dataSource = new BasicDataSource();
            //2.设置四大参数
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/mydb1");
            dataSource.setUsername("root");
            dataSource.setPassword("root123");
            //设置连接池参数
            dataSource.setMaxIdle(3);//最小空闲连接数
            dataSource.setInitialSize(10);
            dataSource.setMaxWait(1000);
            //4.得到Connection
            conn = dataSource.getConnection();
            System.out.println(conn.getClass().getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
