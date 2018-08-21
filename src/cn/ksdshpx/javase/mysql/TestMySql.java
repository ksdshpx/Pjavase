package cn.ksdshpx.javase.mysql;

import org.junit.Test;

import java.sql.*;

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
        //3.创建Statement对象
        Statement stmt = connection.createStatement();
        //4.通过Statement对象发送sql语句
        //String sql = "INSERT INTO emp(empno,ename,deptno) VALUES('5','chaiqi',20)";
        String sql = "UPDATE emp SET ename = 'nuba' WHERE empno = '5'";
        int effectRowNum = stmt.executeUpdate(sql);
        System.out.println("影响的行数:" + effectRowNum);
    }

    @Test
    public void test2() {
        //四大配置参数
        String driverName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mydb1";
        String username = "root";
        String password = "root123";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1.加载驱动
            //Class.forName(driverName);
            //System.setProperty("jdbc.drivers",driverName);
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2.得到连接
            conn = DriverManager.getConnection(url, username, password);
            //3.创建Statement
            stmt = conn.createStatement();
            //4.通过Statement对象发送sql语句
            String sql = "select * from emp";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                int deptno = rs.getInt("deptno");
                System.out.println(empno + "---" + ename + "---" + deptno);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
