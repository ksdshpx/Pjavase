package cn.ksdshpx.javase.jdbc;

import java.sql.*;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/22
 * Time: 10:48
 * Description:SQL注入问题
 */
public class SQLInject {
    public static void main(String[] args) {
        read("' or 1 or'");
        System.out.println("------------------");
        readFixSQLInject("lisi");
    }

    static void read(String ename) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //得到连接
            conn = JdbcUtils.getConnection();
            //创建Statement
            stmt = conn.createStatement();
            //通过Statement对象发送sql语句
            String sql = "select * from emp where ename = '" + ename + "'";
            System.out.println("sql:" + sql);
            rs = stmt.executeQuery(sql);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename2 = rs.getString("ename");
                int deptno = rs.getInt("deptno");
                System.out.println(empno + "\t" + ename2 + "\t" + deptno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, stmt, rs);
        }
    }

    static void readFixSQLInject(String ename) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //得到连接
            conn = JdbcUtils.getConnection();
            //创建Statement
            String sql = "select * from emp where ename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ename);
            System.out.println("sql:" + sql);
            //通过PreparedStatement对象发送sql语句
            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println();
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename2 = rs.getString("ename");
                int deptno = rs.getInt("deptno");
                System.out.println(empno + "\t" + ename2 + "\t" + deptno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }
}
