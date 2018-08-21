package cn.ksdshpx.javase.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/21
 * Time: 19:39
 * Description:java操作mysql
 */
public class TestDBConnection {
    @Test
    public void test() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //得到连接
            conn = JdbcUtils.getConnection();
            //创建Statement
            stmt = conn.createStatement();
            //通过Statement对象发送sql语句
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                int deptno = rs.getInt("deptno");
                System.out.println(empno + "---" + ename + "---" + deptno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, stmt, rs);
        }
    }
}
