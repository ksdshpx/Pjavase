package cn.ksdshpx.javase.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/9/1
 * Time: 14:46
 * Description:数据库的元数据信息
 */
public class DBMetaDataTest {
    @Test
    public void test(){
        try {
            Connection conn = JdbcUtils.getConnection();
            DatabaseMetaData dbMetaData = conn.getMetaData();
            System.out.println("数据库名称:"+dbMetaData.getDatabaseProductName());
            System.out.println("数据库版本:"+dbMetaData.getDatabaseProductVersion());
            System.out.println("是否支持事务:"+dbMetaData.supportsTransactions());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
