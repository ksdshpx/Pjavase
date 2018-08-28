package cn.ksdshpx.javase.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/28
 * Time: 14:59
 * Description:java调用存储过程
 */
public class SpTest {
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();
    @Test
    public void testCallSp(){
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = dataSource.getConnection();
            String sql = "{call addStu(?,?,?,?)}";
            cstmt = conn.prepareCall(sql);
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2,"zhouQi");
            cstmt.setInt(3,29);
            cstmt.setString(4,"female");
            cstmt.executeUpdate();
            System.out.println(cstmt.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JdbcUtils.close(conn,cstmt,null);
        }
    }
}
